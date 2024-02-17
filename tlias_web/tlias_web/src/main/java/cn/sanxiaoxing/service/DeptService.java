package cn.sanxiaoxing.service;

import cn.sanxiaoxing.dao.Dept;

import java.util.List;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/17/20:22
 * @Description:
 */
public interface DeptService {
    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 20:49
     * @Description: 查询全部数据类
     */
    List<Dept> list();

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:12
     * @Description: 删除部门----通过id删除
     */
    void delete(Integer id);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:22
     * @Description: 新增部门
     */
    void add(Dept dept);
}
