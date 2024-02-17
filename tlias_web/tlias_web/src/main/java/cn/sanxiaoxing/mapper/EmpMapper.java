package cn.sanxiaoxing.mapper;

import cn.sanxiaoxing.dao.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/17/20:21
 * @Description:
 */
@Mapper
public interface EmpMapper {

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:52
     * @Description: 查询总记录数
     */
//    @Select("select count(*) from emp")
//    public Long count();

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:55
     * @Description: 分页查询获取列表数据
     */
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 23:45
     * @Description: 员工信息的查询
     */
    @Select("select * from emp")
    public List<Emp> list();
}
