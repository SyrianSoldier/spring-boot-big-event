package com.syriansoldier.big_event.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JwtTest {
    @Autowired
    JwtUtils jwtUtils;

    @Test
    public void genTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("id", 111);
        map.put("username","张三");


        String token =  JWT.create()
                .withClaim("user",map)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .sign(Algorithm.HMAC256("syrianslolder"));

        System.out.println(token);
    }

    @Test
    public void verifyTest(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxMTEsInVzZXJuYW1lIjoi5byg5LiJIn0sImV4cCI6MTczMTkzMjkyMn0.ACa1Fqn_7TZ3blmkcqRwTqy4tNct0x7WYXCvI4wmrNQ";

        JWTVerifier jwtVerify = JWT.require(Algorithm.HMAC256("syrianslolder")).build();
        DecodedJWT decodedJWT = jwtVerify.verify(token);

        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }

    @Test
    public void genTest2(){
        Map<String,Object> map = new HashMap<>();
        map.put("id", 111);
        map.put("username","张三");

        System.out.println(jwtUtils.genJwt(map));
    }

    @Test
    public void verifyTest2(){
        String token = "eyJhbGciOiJIUzINiIsInR5cCI6IkpXVCJ9.eyJBdXRob3JpemF0aW9uIjp7ImlkIjoxMTEsInVzZXJuYW1lIjoi5byg5LiJIn0sImV4cCI6MTczMTk5MjE1N30.RfUften9AWk6x-JpSRa9_8MQU0a023OG0lykRzq_xSk";
        try {
            Map<String, Object> obj = jwtUtils.parseJWT(token);
            System.out.println(obj);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
