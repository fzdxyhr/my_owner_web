package com.yhr.cloud.api;

import com.yhr.cloud.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yhr
 * @version latest
 * @date 2016/10/20
 * @description
 */
@FeignClient(url = "${my.service.url}")
public interface MyStudyApi {

    @RequestMapping(value = "/user/getUserInfo", method = RequestMethod.GET)
    public User getUserInfo();
}
