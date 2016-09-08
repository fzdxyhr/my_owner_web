package com.yhr.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by YHR on 2016/8/13.
 */
@Data
public class UserVo {
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户密码")
    private String password;
    @ApiModelProperty("创建时间")
    private Date createTime;
}
