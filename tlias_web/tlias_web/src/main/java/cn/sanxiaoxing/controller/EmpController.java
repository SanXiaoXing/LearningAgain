package cn.sanxiaoxing.controller;

import cn.sanxiaoxing.dao.PageBean;
import cn.sanxiaoxing.dao.Result;
import cn.sanxiaoxing.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/17/20:19
 * @Description: 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    //@RequestParam(defaultValue="默认值")   //设置请求参数默认值
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询参数page:{},{}", page,pageSize);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize);
        //响应
        return Result.success(pageBean);
    }
}
