//package com.yhr.jdbcTemplate;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * @author yhr
// * @version latest
// * @date 2016/9/8
// * @description
// */
//public interface BaseRepository<T, ID extends Serializable> {
//
//    public List<T> findAll();
//
//    public Integer getTotalCount();
//
//    public T findOne(ID id);
//
//    public T save(T entity);
//
//    public void delete(ID id);
//
//    public void delete(T t) throws Exception;
//
//    public void deleteAll();
//
//}
