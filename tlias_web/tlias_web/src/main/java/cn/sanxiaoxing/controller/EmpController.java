package cn.sanxiaoxing.controller;

import cn.sanxiaoxing.dao.Emp;
import cn.sanxiaoxing.dao.PageBean;
import cn.sanxiaoxing.dao.Result;
import cn.sanxiaoxing.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询参数page:{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender, begin, end);
        //响应
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除参数ids:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("保存参数emp:{}", emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id){
        log.info("查询参数id:{}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping()
    public Result update(@RequestBody Emp emp){
        log.info("更新参数emp:{}", emp);
        empService.update(emp);
        return Result.success();
    }
}
