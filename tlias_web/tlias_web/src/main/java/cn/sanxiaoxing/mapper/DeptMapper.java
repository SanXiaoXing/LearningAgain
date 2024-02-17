package cn.sanxiaoxing.mapper;

import cn.sanxiaoxing.dao.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/17/20:21
 * @Description:
 */
@Mapper
public interface DeptMapper {
    //查询所有部门数据
    @Select("select * from dept")
    List<Dept> list();

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:13
     * @Description: 根据id删除部门信息
     */
    @Select("delete from dept where id=#{id}")
    void deleteById(Integer id);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/17 0017 21:24
     * @Description: 新增部门信息
     */
    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
