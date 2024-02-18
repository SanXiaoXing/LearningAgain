package cn.sanxiaoxing.service.impl;

import cn.sanxiaoxing.dao.Emp;
import cn.sanxiaoxing.dao.PageBean;
import cn.sanxiaoxing.mapper.EmpMapper;
import cn.sanxiaoxing.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/17/20:24
 * @Description:
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

  /*  @Override
    public PageBean page(Integer page, Integer pageSize) {
        //获取总记录数
        Long count = empMapper.count();

        //获取分页查询结果
        Integer start = (page - 1) * pageSize; //计算起始索引 , 公式: (页码-1)*页大小
        List<Emp> empList = empMapper.list(start, pageSize);

        //封装pageBean对象
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }*/

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {

        //设置分页参数
        PageHelper.startPage(page, pageSize);

        //执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //封装pageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
}
