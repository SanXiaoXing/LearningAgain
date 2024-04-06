package cn.sanxiaoxing.controller;

import cn.sanxiaoxing.dao.Emp;
import cn.sanxiaoxing.dao.Result;
import cn.sanxiaoxing.service.EmpService;
import cn.sanxiaoxing.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/03/31/21:16
 * @Description: 登录注册
 */

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("emp:{}", emp);
        Emp e = empService.login(emp);

        // 登录成功，生成令牌，并下发令牌
        if(e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("name", e.getName());

            String jwt = JwtUtils.generateJwt(claims); // jwt包含了当前登录的员工信息
            return Result.success(jwt);
        }

        // 登录失败，返回错误信息
        return Result.error("用户名或密码错误！！！");
    }
}
