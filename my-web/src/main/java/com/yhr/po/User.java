package com.yhr.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yhr
 * @version latest
 * @date 2016/7/20
 * @description
 */
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    private Long id;
    @Column(name = "username")
    private String UserName;
    @Column(name = "password")
    private String password;
}
