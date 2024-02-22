package cn.sanxiaoxing.service;

import cn.sanxiaoxing.dao.Emp;
import cn.sanxiaoxing.dao.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/17/20:24
 * @Description:
 */
public interface EmpService {
    /**
     * 条件分页查询
     * @param page 页码
     * @param pageSize 每页展示记录数
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/18 0018 23:15
     * @Description: 批量删除的方法
     */
    void delete(List<Integer> ids);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/18 0018 23:26
     * @Description: 新增员工
     */
    void save(Emp emp);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/23 0023 0:23
     * @Description: 根据id查询员工
     */
    Emp getById(Integer id);
}
