package cn.sanxiaoxing.mapper;

import cn.sanxiaoxing.dao.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
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
//    @Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/18 0018 23:16
     * @Description: 批量删除操作
     */
    void delete(List<Integer> ids);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/18 0018 23:27
     * @Description: 新增员工信息
     */
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void insert(Emp emp);

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/2/23 0023 0:24
     * @Description: 根据id查询员工
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);
}
