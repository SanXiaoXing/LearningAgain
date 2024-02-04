package cn.sanxiaoxing.springweb.controller;

import cn.sanxiaoxing.projo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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

    @RequestMapping("/simpleParam2")
    public String simpleParam2(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/address")
    public String Address(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/3 0003 15:05
     * @Description: 日期参数
     */
    @RequestMapping("/dataParam")
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM- dd HH:mm:ss") LocalDateTime dateTime) {
        System.out.println(dateTime);
        return "success";
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/3 0003 15:20
     * @Description: json参数
     */
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "success";
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/3 0003 15:20
     * @Description: 路径参数
     */
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParamPro(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id + " :" + name);
        return "success";
    }
}
