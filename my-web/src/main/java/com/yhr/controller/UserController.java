package com.yhr.controller;

import com.yhr.po.User;
import com.yhr.repository.UserRepository;
import com.yhr.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by YHR on 2016/8/13.
 */

@Api("用户管理")
@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> list(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public User create(@ApiParam("用户信息") @RequestBody UserVo userVo){
        User user = new User();
        user.setUserName(userVo.getUserName());
        user.setPassword(userVo.getPassword());
        user.setCreateTime(new Date());
        user = userRepository.save(user);
        return user;
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public void delete(@ApiParam("用户标识") @PathVariable("id") Long id){
        User user = userRepository.findOne(id);
        if(user != null) {
            userRepository.delete(user);
        }
    }

    @ApiOperation("根据id获取用户信息")
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User get(@ApiParam("用户标识") @PathVariable("id") Long id){
        User user = userRepository.findOne(id);
        if(user != null) {
            return user;
        }
        return null;
    }

    @ApiOperation("通过文件方式创建文章")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String createByFile(@ApiParam(value = "文件流", required = true) @RequestParam("articleFile") MultipartFile articleFile){
        System.out.println("success");
        return "success";
    }

}
