package com.yhr;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

/**
 * @author yhr
 * @version latest
 * @date 2016/7/19
 * @description
 */

@SpringBootApplication
@ComponentScan("com")
@EnableFeignClients
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    //主函数
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx =SpringApplication.run(Application.class, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();
        System.out.println("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            System.out.println(bn);
        }
    }

//    @Bean
//    public DynamicDataSourceAspect get(){
//        DynamicDataSourceAspect dynamicDataSourceAspect = new DynamicDataSourceAspect();
//        return dynamicDataSourceAspect;
//    }

    @Bean
    public HttpMessageConverters initJackson() {
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        jacksonConverter.setObjectMapper(objectMapper);
        HttpMessageConverter<?> converter = jacksonConverter;
        return new HttpMessageConverters(converter);
    }
}