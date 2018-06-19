package cn.edu.wic.ssm.mapper;

import static cn.edu.wic.ssm.HrmTool.HrmContants.EMPLOYEETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.edu.wic.ssm.bean.Employee;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月18日 下午2:45:10
 * @version 1.0
 */
public interface EmployeeMapper {
		/**
		 * 分页动态查询
		 * @param Map<String, Object>params
		 * @return List
		 */
		@SelectProvider(type=EmployeeDynaSqlProvider.class,method="selectWithParam")
		List<Employee> selectByPage(Map<String, Object>params);
		
		/**
		 * 根据参数查询员工总数
		 * @param params
		 * @return Integer
		 */
		@SelectProvider(type=EmployeeDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object>params);
		
		/**
		 * 查询所有员工
		 * @param params
		 * @return List
		 */
		@Select("select * from "+EMPLOYEETABLE+" ")
		List<Employee> selectAllEmployee(Map<String, Object>params);
		
		/**
		 * 根据id查询员工
		 * @param id
		 * @return Employee
		 */
		@Select("select * from" +EMPLOYEETABLE+" where id = #{id}")
		Employee selectById(Integer id);
		
		/**
		 * 根据id删除员工
		 * @param id
		 */
		@Delete(" delete from "+EMPLOYEETABLE+" where id = #{id}")
		void deleteByid(Integer id);
		
		/**
		 * 动态插入员工
		 * @param employee
		 * @return int
		 */
		@SelectProvider(type=EmployeeDynaSqlProvider.class,method="insertEmployee")
		int save(Employee employee);
		
		/**
		 * 动态修改员工
		 * @param employee
		 * @return int
		 */
		@SelectProvider(type=EmployeeDynaSqlProvider.class,method="updateEmployee")
		int update(Employee employee);

}
