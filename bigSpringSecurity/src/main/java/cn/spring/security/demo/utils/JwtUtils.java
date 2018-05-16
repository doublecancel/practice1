package cn.spring.security.demo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/10.
 */
@Component
public final class JwtUtils {

    @Value("${jwt.privateSecret}")
    private String privateSecret;
    @Value("${jwt.expireTime}")
    private Long expireTime;//5s

    @Autowired
    HttpServletRequest request;

    @Value("${jwt.header}")
    private String header;

    public String generateToken(Map<String, Object> claims){

        return Jwts.builder()
                .addClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, privateSecret)
                .compact();

    }

    public Map<String, Object> getClaims(String token){
        try {

            return Jwts.parser()
                    .setSigningKey(privateSecret)
                    .setClock(DefaultClock.INSTANCE)
                    .parseClaimsJws(token)
                    .getBody();

        } catch (Exception e){
            return null;
        }
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expireTime);
    }


}
