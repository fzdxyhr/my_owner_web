package com.yhr.controller;

import com.yhr.datasource.TargetDataSource;
import com.yhr.po.User;
import com.yhr.repository.MyJdbcTemplate;
import com.yhr.service.UserService;
import com.yhr.util.ExportExcelUtil;
import com.yhr.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author yhr
 * @version latest
 * @date 2016/9/7
 * @description
 */
@Api("用户测试template管理")
@RestController
@RequestMapping("/v2")
public class UserTemplateController {

    @Autowired
    private MyJdbcTemplate myJdbcTemplate;
    @Autowired
    private UserService userService;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> list() {
        List<User> users = myJdbcTemplate.findAll();
        return users;
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User create(@ApiParam("用户信息") @RequestBody UserVo userVo) throws Exception {
        User user = new User();
        user.setUserName(userVo.getUserName());
        user.setPassword(userVo.getPassword());
        user.setCreateTime(new Date());
        user = myJdbcTemplate.save(user);
        return user;
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/users2", method = RequestMethod.POST)
    @TargetDataSource(value = "ds2")
    public User create2(@ApiParam("用户信息") @RequestBody UserVo userVo) throws Exception {
        User user = new User();
        user.setUserName(userVo.getUserName());
        user.setPassword(userVo.getPassword());
        user.setCreateTime(new Date());
        user = myJdbcTemplate.save(user);
        return user;
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/users3", method = RequestMethod.POST)
    @TargetDataSource(value = "ds3")
    public User create3(@ApiParam("用户信息") @RequestBody UserVo userVo) throws Exception {
        User user = new User();
        user.setUserName(userVo.getUserName());
        user.setPassword(userVo.getPassword());
        user.setCreateTime(new Date());
        user = myJdbcTemplate.save(user);
        return user;
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void delete(@ApiParam("用户标识") @PathVariable("id") Long id) throws Exception {
        User user = myJdbcTemplate.findOne(id);
        if (user != null) {
            myJdbcTemplate.delete(user);
        }
    }

    @ApiOperation("根据id获取用户信息")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User get(@ApiParam("用户标识") @PathVariable("id") Long id) {
        return userService.get(id);
    }

    @ApiOperation("根据id获取用户信息")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse response) {
        List<User> users = myJdbcTemplate.findAll();
        ExportExcelUtil<User> ex = new ExportExcelUtil<User>();
        String[] headers = {"序号", "姓名", "密码", "创建时间"};
        ex.exportExcel("测试", headers, users, "yyyy-MM-dd HH:mm:ss", "用户列表", response);
    }

}
