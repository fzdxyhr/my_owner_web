package com.yhr.cloud.controller;

import com.yhr.cloud.vo.User;
import com.yhr.cloud.api.MyStudyApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yhr
 * @version latest
 * @date 2016/10/20
 * @description
 */

@RestController
@RequestMapping(value = "/v1")
public class MyStudyController {

    @Autowired
    private MyStudyApi myStudyApi;

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public User getUserInfo() {
        User user = myStudyApi.getUserInfo();
        return user;
    }
}
