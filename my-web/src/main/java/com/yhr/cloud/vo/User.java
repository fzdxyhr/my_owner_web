package com.yhr.cloud.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author yhr
 * @version latest
 * @date 2016/3/25
 * @description
 */
@RequestMapping("/user")
public class User {
    @ApiModelProperty("标识")
    private int Id;

    @ApiModelProperty("标识")
    private String UserName;

    @ApiModelProperty("标识")
    private String Password;


    private Date CreateTime;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }
}
