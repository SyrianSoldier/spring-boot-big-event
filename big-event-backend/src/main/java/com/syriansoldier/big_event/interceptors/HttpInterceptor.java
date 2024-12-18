package com.syriansoldier.big_event.interceptors;

import com.syriansoldier.big_event.utils.JwtUtils;
import com.syriansoldier.big_event.utils.Result;
import com.syriansoldier.big_event.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            String token = request.getHeader(tokenHeader);
            String redisToken = redisTemplate.opsForValue().get("token");
            if (redisToken == null || !token.equals(redisToken)) {
                response.setStatus(401);
                return false;
            }

            Map<String, Object> claims = jwtUtils.parseJWT(token);
            ThreadLocalUtils.set(claims);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        ThreadLocalUtils.remove();
    }
}
