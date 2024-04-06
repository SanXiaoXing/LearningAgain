package cn.sanxiaoxing;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ServletComponentScan //
@SpringBootTest
class TliasWebApplicationTests {

//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    public void testUnid(){
//        for (int i = 0; i < 100; i++) {
//            String uuid = UUID.randomUUID().toString();
//            System.out.println(uuid);
//        }
//    }

    /**
    * @Author: SanXiaoXing
    * @Date: 2024/4/6
    * @Description: 生成JWT令牌
    */
    @Test
    public void testJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","sanxiaoxing");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"sanxiaoxing")//签名算法
                .setClaims(claims)//自定义参数
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))//过期时间
                .compact();
        System.out.println(jwt);
    }

    /**
    * @Author: SanXiaoXing
    * @Date: 2024/4/6
    * @Description: 解析JWT令牌
    */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("sanxiaoxing")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoic2FueGlhb3hpbmciLCJpZCI6MSwiZXhwIjoxNzEyNDk1NDg5fQ.BthEvI1I5dwZh3MMvdED4nEZ5orDYi8NT2osYlknpQ8")
                .getBody();
        System.out.println(claims);
    }
}
