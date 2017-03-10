package com.yhr.po;

import lombok.Data;

import javax.persistence.*;

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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    //@Column(name = "create_time")
    //private Date createTime;
}
