package com.syriansoldier.big_event.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {
    @Value("${token.secret}")
    private String SECRET_KEY;

    @Value("${token.expire_minutes}")
    private long EXPIRES_MINUTES;

    @Value("${token.header}")
    private String claimsKey;
    /**
     * 生成JWT令牌
     */
    public String genJwt(Map<String, Object> claims){
        return JWT.create()
                .withClaim(claimsKey, claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * EXPIRES_MINUTES))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    /**
     * 解析JWT令牌, 并取出token中的payload
     */
    public Map<String, Object> parseJWT(String token){
        return JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build()
                .verify(token)
                .getClaims()
                .get(claimsKey)
                .asMap();
    }
}
