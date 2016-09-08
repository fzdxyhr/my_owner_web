package com.yhr.repository;

import com.yhr.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YHR on 2016/8/13.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
