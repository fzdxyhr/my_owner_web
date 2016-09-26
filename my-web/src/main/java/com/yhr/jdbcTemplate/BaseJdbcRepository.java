package com.yhr.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yhr
 * @version latest
 * @date 2016/9/6
 * @description
 */

public class BaseJdbcRepository<T,ID extends Serializable> {

    private Class<T> entityClass;
    private Class<ID> typeEntityClass;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BaseJdbcRepository() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
        typeEntityClass = (Class) params[1];
    }

    public List<T> findAll() {
        String tableName = this.getTableName();
        StringBuffer sql = new StringBuffer("select * from " + tableName);
        return jdbcTemplate.query(sql.toString(), new Object[]{}, new BeanPropertyRowMapper<T>(entityClass));
    }

    public Integer getTotalCount() {
        String tableName = this.getTableName();
        StringBuffer sql = new StringBuffer("select count(*) from " + tableName);
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }

    public T findOne(ID id) {
        String tableName = this.getTableName();
        String sql = "select * from " + tableName + " where " + getPrimaryKey() + "=?";
        List<Object> args = new ArrayList<Object>();
        args.add(id);
        List<T> list = jdbcTemplate.query(sql, args.toArray(), new BeanPropertyRowMapper<T>(entityClass));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    public T save(T entity) {
        try {
            Class clazz = entity.getClass();
            Field[] fields = clazz.getDeclaredFields();
            StringBuffer columns = new StringBuffer();
            StringBuffer values = new StringBuffer();
            for (Field field : fields) {
                String name = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method method = clazz.getMethod("get" + name);
                Object value = method.invoke(entity);
                if (value != null) {//获取不为空的字段名
                    String columnName = null;
                    if(field.isAnnotationPresent(Id.class) && !field.isAnnotationPresent(Column.class)) {
                        columnName = field.getName();
                    }
                    else {
                        Column column = field.getAnnotation(Column.class);
                        columnName = column.name();
                    }
                    columns.append("," + columnName);
                }
                if(value != null) {
                    if(value instanceof Date) {
                        value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
                    }
                    values.append(",\"" + value + "\"");
                }
            }
            values.deleteCharAt(0);
            columns.deleteCharAt(0);
            StringBuffer sql = new StringBuffer("insert into " + this.getTableName() +"("+ columns.toString() + ") values(");
            sql.append(values.toString() + ")");
            this.jdbcTemplate.execute(sql.toString());
            ID value = this.getMaxCount();
            //返回数据库中的数据
            entity = this.findOne(value);
            return entity;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(ID id) {
        String tableName = this.getTableName();
        String sql = "delete from " + tableName + " where " + getPrimaryKey() + "=?";
        List<Object> args = new ArrayList<Object>();
        args.add(id);
        this.jdbcTemplate.execute(sql);
    }

    public void delete(T t) throws Exception {
        String tableName = this.getTableName();
        Object idValue = null;
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                String name = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method method = clazz.getMethod(name);
                idValue = method.invoke(t);
            }
        }
        String sql = "delete from " + tableName + " where " + getPrimaryKey() + "=?";
        List<Object> args = new ArrayList<Object>();
        args.add(idValue);
        this.jdbcTemplate.execute(sql);
    }

    public void deleteAll() {
        String tableName = this.getTableName();
        String sql = "delete from " + tableName;
        this.jdbcTemplate.execute(sql);
    }

    private ID getMaxCount() {
        String tableName = this.getTableName();
        StringBuffer sql = new StringBuffer("select max(" + getPrimaryKey() + ") from " + tableName);
        return jdbcTemplate.queryForObject(sql.toString(), typeEntityClass);
    }


    private String getTableName() {
        //获取注解
        Table table = entityClass.getAnnotation(Table.class);
        String tableName = null;
        tableName = table.name();
        return tableName;
    }

    private String getPrimaryKey() {
        String primaryKey = null;
        //获取实体类定义字段
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                if (!field.isAnnotationPresent(Column.class)) {//有@Id标识，没有@Column标注，直接取filed name
                    primaryKey = field.getName();
                } else {
                    Column column = field.getAnnotation(Column.class);
                    primaryKey = column.name();
                }
                break;
            }
        }
        return primaryKey;
    }

}
