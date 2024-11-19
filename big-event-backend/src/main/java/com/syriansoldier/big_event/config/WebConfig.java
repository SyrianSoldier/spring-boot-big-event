package com.syriansoldier.big_event.config;

import com.syriansoldier.big_event.interceptors.HttpInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    HttpInterceptor httpInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] ignores = new String[]{"/user/login", "/user/register"};

        registry.addInterceptor(httpInterceptor).excludePathPatterns(ignores);
    }
}
