package com.yhr.util;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author yhr
 * @version latest
 * @date 2017/3/10
 * @description
 */
public class JdbcUtil {

    /**
     * @param prefix   字段名称
     * @param object   值对象
     * @param params   参数对象
     * @param needAnd  是否需要and
     * @param openLike 开启字段 like 查询
     * @return
     */
    public static String mergeSql(String prefix, Object object, List<Object> params, boolean needAnd, boolean... openLike) {
        StringBuffer sql = new StringBuffer();
        if (needAnd) {
            sql.append(" and ");
        }
        sql.append(prefix);
        if (object instanceof Collection) {//集合方式处理
            StringBuffer temp = new StringBuffer();
            sql.append(" in(");
            Collection collection = (Collection) object;
            for (Object target : collection) {
                temp.append(",?");
                if (target instanceof UUID) {
                    params.add(target.toString());
                } else {
                    params.add(target);
                }

            }
            if (temp.length() > 0) {
                sql.append(temp.deleteCharAt(0));
            }
            sql.append(")");
        } else if (object.getClass().isArray()) {//数组方式处理
            StringBuffer temp = new StringBuffer();
            sql.append(" in(");
            Object[] objects = (Object[]) object;
            for (Object target : objects) {
                temp.append(",?");
                params.add(target);
            }
            if (temp.length() > 0) {
                sql.append(temp.deleteCharAt(0));
            }
            sql.append(")");
        } else {
            if (openLike.length > 0 && openLike[0]) {//启用like功能
                sql.append(" like ?");
                params.add("%" + object + "%");
            } else {
                sql.append(" = ?");
                if (object instanceof UUID) {//处理UUID直接传入查询不出结果问题，需要将其转换为字符串
                    params.add(object.toString());
                } else {
                    params.add(object);
                }
            }
        }
        return sql.toString();
    }

}
