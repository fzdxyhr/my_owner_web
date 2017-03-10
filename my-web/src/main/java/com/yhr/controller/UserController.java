package com.yhr.controller;

import com.yhr.po.User;
import com.yhr.repository.UserRepository;
import com.yhr.util.ExportExcelUtil;
import com.yhr.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //user.setCreateTime(new Date());
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

    @ApiOperation("根据id获取用户信息")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void getExcel(HttpServletResponse response){
        List<User> users = userRepository.findAll();
        ExportExcelUtil<User> exportExcelUtil = new ExportExcelUtil<User>();
        String[] headers = new String[]{"序号","用户名","密码","创建时间"};
        Map<String,String> operationMap = new HashMap<String, String>();
        operationMap.put("userName","add");
        operationMap.put("password","replace");
        Map<String,Object> valueMap = new HashMap<String, Object>();
        valueMap.put("userName","%");
        valueMap.put("password","-");
        exportExcelUtil.exportExcel("aa",headers,users,"yyyy-MM-dd HH:mm:ss","aas",response,operationMap,valueMap);
    }

}
