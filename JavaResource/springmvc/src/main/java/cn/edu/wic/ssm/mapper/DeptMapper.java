package cn.edu.wic.ssm.mapper;
/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月17日 下午9:50:29
 * @version 1.0
 */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import  static cn.edu.wic.ssm.HrmTool.HrmContants.DEPTTABLE; 
import cn.edu.wic.ssm.bean.Dept;

public interface DeptMapper {
	
	/**
	 * 分页动态查询
	 * @param Map<String, Object>params
	 * @return List
	 */
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWithParam")
	List<Dept> selectByPage(Map<String, Object>params);
	
	/**
	 * 根据参数查询部门总数
	 * @param Map<String, Object>params
	 * @return Integer
	 */
	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object>params);
	
	/**
	 * 查询所有部门
	 * @param Map<String, Object>params
	 * @return List
	 */
	@Select("select * from "+DEPTTABLE+" ")
	List<Dept> selectAllDept();
	
	/**
	 * 根据id查询部门
	 * @param Integer id
	 * @return Dept
	 */
	@Select("select * from" +DEPTTABLE+" where id = #{id}")
	Dept selectById(Integer id);
	
	/**
	 * 根据id删除部门
	 * @param Integer id
	 */
	@Delete(" delete from "+DEPTTABLE+" where id = #{id}")
	void deleteByid(Integer id);
	
	/**
	 * 动态插入部门
	 * @param Dept dept
	 * @return int
	 */
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	int save(Dept dept);
	
	/**
	 * 动态修改部门
	 * @param Dept dept
	 * @return int
	 */
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	int update(Dept dept);
}
