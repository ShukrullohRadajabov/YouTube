package com.company.YouTubeProject.config;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SecuredFilterConfig {
//    @Autowired
//    private TokenFilter tokenFilter;

//    @Bean
//    public FilterRegistrationBean<Filter> filterRegistrationBean() {
//        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
//        bean.setFilter(tokenFilter);
//        bean.addUrlPatterns("/api/v1/article/private/*");
//        // /api/v1/article/*
//        //  /api/v1/article/
//        //  /api/v1/article/84ab391b-2d99-452e-8bc4-5cf2003e389d
//
//        return bean;
//    }

}
