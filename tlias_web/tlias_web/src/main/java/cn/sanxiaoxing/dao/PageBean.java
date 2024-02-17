package cn.sanxiaoxing.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/17/21:45
 * @Description: 分页查询结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PageBean {
    private Long total; //总记录数
    private List rows; //数据列表
}

