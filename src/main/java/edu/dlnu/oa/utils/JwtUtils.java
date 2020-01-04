package edu.dlnu.oa.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuhan
 * @date 2020/1/3 15:09
 */
public class JwtUtils {
    static final String SECRET = "ThisIsASecret";
    public static String generateToken(String username,int empId,int empRoleId){
        Map<String,Object> map = new HashMap<>();
        map.put("empName",username);
        map.put("empId",empId);
        map.put("empRoleId",empRoleId);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L)) //1000 hour
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return "Bearer "+jwt;
    }
    public static void validateToken(String token) {
        try {
            // parse the token.
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ",""))
                    .getBody();
        }catch (Exception e){
            throw new IllegalStateException("Invalid Token. "+e.getMessage());
        }
    }

}
