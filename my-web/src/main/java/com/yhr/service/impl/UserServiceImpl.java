package com.yhr.service.impl;

import com.yhr.datasource.TargetDataSource;
import com.yhr.po.User;
import com.yhr.repository.MyJdbcTemplate;
import com.yhr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yhr
 * @version latest
 * @date 2016/9/20
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyJdbcTemplate myJdbcTemplate;

    @Override
    @TargetDataSource(value = "ds1")
    public User get(Long id) {
        User user = myJdbcTemplate.findOne(id);
        if (user != null) {
            return user;
        }
        return null;
    }
}
