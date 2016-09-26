package com.yhr.base;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author yhr
 * @version latest
 * @date 2016/9/20
 * @description
 */
@Configuration
public class WebApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("556565");
    }
}
