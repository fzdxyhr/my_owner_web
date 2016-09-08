package com.yhr.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yhr
 * @version latest
 * @date 2016/9/7
 * @description
 */

@Data
@Entity
@Table(name = "teacher")
public class teacher {
    @Id
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
}
