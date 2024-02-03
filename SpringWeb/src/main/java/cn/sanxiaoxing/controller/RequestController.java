package cn.sanxiaoxing.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/03/12:35
 * @Description:
 */
@RestController
public class RequestController {

    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        Integer ageInt = Integer.parseInt(age);
        System.out.println(name + ageInt);
        return "success";
    }
}
