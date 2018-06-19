package cn.edu.wic.ssm.mapper;
/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月17日 下午4:36:16
 * @version 1.0
 */

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import cn.edu.wic.ssm.bean.User;
import  static cn.edu.wic.ssm.HrmTool.HrmContants.USERTABLE ;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	
	/** 
	 * @Title: selectByUsernamePassword 
	 * @Description: 根据用户名和密码查询用户
	 * @param loginname
	 * @param password
	 * @return User 
	 * @throws 
	 */
	@Select("select * from" +USERTABLE + " where loginname=#{loginname} and password = #{password} and status>0" )
	User selectByUsernamePassword(@Param("loginname") String loginname,String password);
	
	/** 
	 * @Title: selectById 
	 * @Description: 根据id查询用户
	 * @param id
	 * @return User 
	 * @throws 
	 */
	@Select("select * from" +USERTABLE +" where id=#{id}")
	User selectById(Integer id);
	
	/** 
	 * @Title: deleteById 
	 * @Description: 根据id删除用户
	 * @param id
	 * @return int 
	 * @throws 
	 */
	@Update("update" +USERTABLE+" set status=0")
	int deleteById(Integer id);
	
	/** 
	 * @Title: updateUser 
	 * @Description: 动态修改用户
	 * @param user void 
	 * @throws 
	 */
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void updateUser(User user);
	
	/** 
	 * @Title: selectByPage 
	 * @Description: 动态查询
	 * @param params
	 * @return List<User> 
	 * @throws 
	 */
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWithUser")
	List<User> selectByPage(Map<String, Object>params);
	
	/** 
	 * @Title: count 
	 * @Description: 根据参数查询用户总数
	 * @param params
	 * @return Integer 
	 * @throws 
	 */
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object>params);
	
	/** 
	 * @Title: save 
	 * @Description: 动态插入用户
	 * @param user
	 * @return int 
	 * @throws 
	 */
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	int save(User user);
}
