package cn.sanxiaoxing.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/04/06/21:15
 * @Description: 生成JWT令牌
 */
public class JwtUtils {

    private static String signKey = "sanxiaoxing";
    private static Long expire = 4320000L; // 过期时间为 12 小时
    
    /**
    * @Author: SanXiaoXing
    * @Date: 2024/4/6
    * @Param: claims JWT第二部分负载 payload 中存储的内容
    * @return: 
    * @Description: 生成JWT令牌
    */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }
    
    /**
    * @Author: SanXiaoXing
    * @Date: 2024/4/6
    * @Param: jwt JWT令牌
    * @return: JWT令牌第二部分负载 payload 中存储的内容
    * @Description: 解析JWT令牌
    */

    public static Map<String, Object> parseJwt(String jwt) {
        return Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
