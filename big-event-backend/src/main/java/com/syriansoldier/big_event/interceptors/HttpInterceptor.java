package com.syriansoldier.big_event.interceptors;

import com.syriansoldier.big_event.utils.JwtUtils;
import com.syriansoldier.big_event.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class HttpInterceptor implements HandlerInterceptor {
    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String header = request.getHeader(tokenHeader);
            jwtUtils.parseJWT(header);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }
}
