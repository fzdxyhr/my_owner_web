package com.yhr.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by YHR on 2016/8/13.
 */
@Data
public class UserVo {
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户名")
    private String UserName;
    @ApiModelProperty("用户密码")
    private String password;
}
