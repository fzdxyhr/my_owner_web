package com.yhr.repository;

import com.yhr.jdbcTemplate.BaseJdbcRepository;
import com.yhr.po.User;
import org.springframework.stereotype.Repository;

/**
 * @author yhr
 * @version latest
 * @date 2016/9/6
 * @description
 */
@Repository
public class MyJdbcTemplate extends BaseJdbcRepository<User,Long> {

}
