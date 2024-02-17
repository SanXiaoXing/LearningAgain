package cn.sanxiaoxing.controller;

import cn.sanxiaoxing.dao.Dept;
import cn.sanxiaoxing.dao.Result;
import cn.sanxiaoxing.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/17/20:18
 * @Description: 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);
//    @RequestMapping(value = "/depts",method = RequestMethod.GET) //指定请求方式为Get
    @Autowired
    private DeptService deptService;

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:08
     * @Description: 查询部门数据
     */
    @GetMapping
    public Result list() {
//        System.out.println("查询部门全部数据");
        log.info("查询部门全部数据");

        //调用service查询部门数据
        List<Dept> deptsList = deptService.list();
        return Result.success(deptsList);
    }


    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:09
     * @Description: 删除部门数据
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除部门数据{}",id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:19
     * @Description: 增加部门q数据
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("增加部门数据{}",dept);
        //调用service增加部门数据
        deptService.add(dept);
        return Result.success();
    }
}
