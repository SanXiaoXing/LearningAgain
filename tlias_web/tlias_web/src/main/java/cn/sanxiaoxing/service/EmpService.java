package cn.sanxiaoxing.service;

import cn.sanxiaoxing.dao.PageBean;

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
    PageBean page(Integer page, Integer pageSize);
}
