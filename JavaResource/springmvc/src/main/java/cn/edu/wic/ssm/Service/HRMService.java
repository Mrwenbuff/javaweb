package cn.edu.wic.ssm.Service;

import java.util.List;
import java.util.Map;

import cn.edu.wic.ssm.HrmTool.PageModel;
import cn.edu.wic.ssm.bean.Dept;
import cn.edu.wic.ssm.bean.Employee;
import cn.edu.wic.ssm.bean.Job;
import cn.edu.wic.ssm.bean.Notice;
import cn.edu.wic.ssm.bean.User;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @Description: 业务逻辑接口
 * @date 创建时间：2018年6月19日 下午7:19:11
 * @version 1.0
 */
public interface HRMService {
	
	/**用户*/
	

	/** 
	 * @Title: login 
	 * @Description: 用户登录
	 * @param username
	 * @param password
	 * @return User    
	 * @throws 
	 */
	User login(String loginname,String password);
	
	/** 
	 * @Title: findUserByid 
	 * @Description: 根据id查询用户
	 * @param id
	 * @return User    
	 * @throws 
	 */
	User findUserByid(Integer id);
	
	
	/** 
	 * @Title: findUser 
	 * @Description: 获取所有用户
	 * @param user 查询条件
	 * @param pageModel 分页对象
	 * @return List<User>    
	 * @throws 
	 */
	List<User>findUser(User user,PageModel pageModel);
	
	/** 
	 * @Title: removeUserByid 
	 * @Description: 根据id删除一个用户
	 * @param id 
	 * @return void    
	 * @throws 
	 */
	void removeUserByid(Integer id);
	
	/** 
	 * @Title: modifyUser 
	 * @Description: 修改用户
	 * @param user 
	 * @return void    
	 * @throws 
	 */
	void modifyUser(User user);
	
	/** 
	 * @Title: addUser 
	 * @Description: 添加用户
	 * @param user void 
	 * @throws 
	 */
	void addUser(User user);
	
	/**员工*/
	
	
	/** 
	 * @Title: findEmployee 
	 * @Description: 获得所有员工
	 * @param employee 查询条件
	 * @param pageModel 分页对象
	 * @return List<Employee> 
	 * @throws 
	 */
	List<Employee>findEmployee(Employee employee,PageModel pageModel);
	
	/** 
	 * @Title: removeEmployeeByid 
	 * @Description: 根据id删除员工
	 * @param id void 
	 * @throws 
	 */
	void removeEmployeeByid(Integer id);
	
	/** 
	 * @Title: findEmployeeByid 
	 * @Description: 根据id查询员工
	 * @param id
	 * @return Employee 
	 * @throws 
	 */
	Employee findEmployeeByid(Integer id);
	
	/** 
	 * @Title: addEmployee 
	 * @Description: 添加员工
	 * @param employee void 
	 * @throws 
	 */
	void addEmployee(Employee employee);
	
	/** 
	 * @Title: modifyEmployee 
	 * @Description: 修改员工
	 * @param employee void 
	 * @throws 
	 */
	void modifyEmployee(Employee employee);
	
	
	/**部门*/
	
	
	/** 
	 * @Title: findDept 
	 * @Description: 获得所有部门，分页查询
	 * @param dept 查询条件
	 * @param pageModel 分页对象
	 * @return List<Dept> 
	 * @throws 
	 */
	List<Dept>findDept(Dept dept,PageModel pageModel);
	
	/** 
	 * @Title: findAllDept 
	 * @Description: 获得所有部门
	 * @return List<Dept> 
	 * @throws 
	 */
	List<Dept>findAllDept();
	
	/** 
	 * @Title: removeDeptByid 
	 * @Description: 根据id删除部门
	 * @param id void 
	 * @throws 
	 */
	void removeDeptByid(Integer id);
	
	/** 
	 * @Title: addDept 
	 * @Description: 添加部门
	 * @param dept void 
	 * @throws 
	 */
	void addDept(Dept dept);
	
	/** 
	 * @Title: findDeptByid 
	 * @Description: 根据id查询部门
	 * @param id
	 * @return Dept 
	 * @throws 
	 */
	Dept findDeptByid(Integer id);
	
	/** 
	 * @Title: modifyDept 
	 * @Description: 修改部门
	 * @param dept void 
	 * @throws 
	 */
	void modifyDept(Dept dept);
	
	/**职位*/
	
	
	/** 
	 * @Title: findAllJob 
	 * @Description: 获得所有职位
	 * @return List<Job> 
	 * @throws 
	 */
	List<Job>findAllJob();
	
	/** 
	 * @Title: findJob 
	 * @Description: 获得所有职位，分页查询
	 * @param job
	 * @param pageModel
	 * @return List<Job> 
	 * @throws 
	 */
	List<Job>findJob(Job job,PageModel pageModel);
	
	/** 
	 * @Title: removeJobByid 
	 * @Description: 根据id删除职位
	 * @param id void 
	 * @throws 
	 */
	void removeJobByid(Integer id);
	
	/** 
	 * @Title: addJob 
	 * @Description: 添加职位
	 * @param job void 
	 * @throws 
	 */
	void addJob(Job job); 
	
	/** 
	 * @Title: findJobByid 
	 * @Description: 根据id查询职位
	 * @param id
	 * @return Job 
	 * @throws 
	 */
	Job findJobByid(Integer id);
	
	/** 
	 * @Title: modifyJob 
	 * @Description: 修改职位
	 * @param job void 
	 * @throws 
	 */
	void modifyJob(Job job);
	
	/**公告*/
	
	
	/** 
	 * @Title: findNotice 
	 * @Description: 获得所有公告
	 * @param notice
	 * @param pageModel
	 * @return List<Notice> 
	 * @throws 
	 */
	List<Notice>findNotice(Notice notice,PageModel pageModel);
	
	/** 
	 * @Title: findNoticeByid 
	 * @Description: 根据id查询公告
	 * @param id
	 * @return Notice 
	 * @throws 
	 */
	Notice findNoticeByid(Integer id);
	
	/** 
	 * @Title: removeNoticeByid 
	 * @Description: 根据id删除公告
	 * @param id void 
	 * @throws 
	 */
	void removeNoticeByid(Integer id);
	
	/** 
	 * @Title: addNotice 
	 * @Description: 添加公告
	 * @param notice void 
	 * @throws 
	 */
	void addNotice(Notice notice);
	
	/** 
	 * @Title: modifyNotice 
	 * @Description: 修改公告
	 * @param notice void 
	 * @throws 
	 */
	void modifyNotice(Notice notice);
	
	/**文档*/
}
