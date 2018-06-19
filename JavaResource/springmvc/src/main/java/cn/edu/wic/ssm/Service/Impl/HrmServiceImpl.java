package cn.edu.wic.ssm.Service.Impl;
/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @Description: 用户服务接口实现
 * @date 创建时间：2018年6月19日 下午8:30:13
 * @version 1.0
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wic.ssm.HrmTool.PageModel;
import cn.edu.wic.ssm.Service.HRMService;
import cn.edu.wic.ssm.bean.Dept;
import cn.edu.wic.ssm.bean.Employee;
import cn.edu.wic.ssm.bean.Job;
import cn.edu.wic.ssm.bean.Notice;
import cn.edu.wic.ssm.bean.User;
import cn.edu.wic.ssm.mapper.DeptMapper;
import cn.edu.wic.ssm.mapper.EmployeeMapper;
import cn.edu.wic.ssm.mapper.JobMapper;
import cn.edu.wic.ssm.mapper.NoticeMapper;
import cn.edu.wic.ssm.mapper.UserMapper;

@Service("hrmService")
public class HrmServiceImpl implements HRMService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private JobMapper jobMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	
	/**用户服务接口实现*/

	
	
	/** Title: login
	 * @see cn.edu.wic.ssm.Service.HRMService#login(java.lang.String, java.lang.String)
	 */
	public User login(String loginname, String password) {
		return userMapper.selectByUsernamePassword(loginname, password);
	}

	/** Title: findUserByid
	 * @see cn.edu.wic.ssm.Service.HRMService#findUserByid(java.lang.Integer)
	 */
	public User findUserByid(Integer id) {
		return userMapper.selectById(id);
	}

	/** Title: findUser
	 * @see cn.edu.wic.ssm.Service.HRMService#findUser(cn.edu.wic.ssm.bean.User, cn.edu.wic.ssm.HrmTool.PageModel)
	 */
	public List<User> findUser(User user, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Title: removeUserByid
	 * @see cn.edu.wic.ssm.Service.HRMService#removeUserByid(java.lang.Integer)
	 */
	public void removeUserByid(Integer id) {
		userMapper.deleteById(id);
	}

	/** Title: modifyUser
	 * @see cn.edu.wic.ssm.Service.HRMService#modifyUser(cn.edu.wic.ssm.bean.User)
	 */
	public void modifyUser(User user) {
		userMapper.updateUser(user);
	}

	/** Title: addUser
	 * @see cn.edu.wic.ssm.Service.HRMService#addUser(cn.edu.wic.ssm.bean.User)
	 */
	public void addUser(User user) {
		userMapper.save(user);
	}

	/** Title: findEmployee
	 * @see cn.edu.wic.ssm.Service.HRMService#findEmployee(cn.edu.wic.ssm.bean.Employee, cn.edu.wic.ssm.HrmTool.PageModel)
	 */
	public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
		/**当前需要分页的数据条数*/
		Map<String, Object>params = new HashMap<String, Object>();
		params.put("employee", employee);
		int recordCount = employeeMapper.count(params);
		System.out.println("recordCount---->>"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0) {
			/**开始分页查询数据：查询第几页数据*/
			params.put("pageModel", pageModel);
		}
		return employeeMapper.selectByPage(params);
	}

	/** Title: removeEmployeeByid
	 * @see cn.edu.wic.ssm.Service.HRMService#removeEmployeeByid(java.lang.Integer)
	 */
	public void removeEmployeeByid(Integer id) {
		employeeMapper.deleteByid(id);
	}

	/** Title: findEmployeeByid
	 * @see cn.edu.wic.ssm.Service.HRMService#findEmployeeByid(java.lang.Integer)
	 */
	public Employee findEmployeeByid(Integer id) {
		return employeeMapper.selectById(id);
	}

	/** Title: addEmployee
	 * @see cn.edu.wic.ssm.Service.HRMService#addEmployee(cn.edu.wic.ssm.bean.Employee)
	 */
	public void addEmployee(Employee employee) {
		employeeMapper.save(employee);
	}

	/** Title: modifyEmployee
	 * @see cn.edu.wic.ssm.Service.HRMService#modifyEmployee(cn.edu.wic.ssm.bean.Employee)
	 */
	public void modifyEmployee(Employee employee) {
		employeeMapper.update(employee);
	}

	/** Title: findDept
	 * @see cn.edu.wic.ssm.Service.HRMService#findDept(cn.edu.wic.ssm.bean.Dept, cn.edu.wic.ssm.HrmTool.PageModel)
	 */
	public List<Dept> findDept(Dept dept, PageModel pageModel) {
		/**当前需要分页的数据条数*/
		Map<String, Object>params = new HashMap<String, Object>();
		params.put("dept", dept);
		int recordCount = deptMapper.count(params);
		System.out.println("recordCount---->>"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0) {
			/**开始分页查询数据：查询第几页数据*/
			params.put("pageModel", pageModel);
		}
		return deptMapper.selectByPage(params);
	}

	/** Title: findAllDept
	 * @see cn.edu.wic.ssm.Service.HRMService#findAllDept()
	 */
	public List<Dept> findAllDept() {
		return deptMapper.selectAllDept();
	}

	/** Title: removeDeptByid
	 * @see cn.edu.wic.ssm.Service.HRMService#removeDeptByid(java.lang.Integer)
	 */
	public void removeDeptByid(Integer id) {
		deptMapper.deleteByid(id);
	}

	/** Title: addDept
	 * @see cn.edu.wic.ssm.Service.HRMService#addDept(cn.edu.wic.ssm.bean.Dept)
	 */
	public void addDept(Dept dept) {
		deptMapper.save(dept);
	}

	/** Title: findDeptByid
	 * @see cn.edu.wic.ssm.Service.HRMService#findDeptByid(java.lang.Integer)
	 */
	public Dept findDeptByid(Integer id) {
		return deptMapper.selectById(id);
	}

	/** Title: modifyDept
	 * @see cn.edu.wic.ssm.Service.HRMService#modifyDept(cn.edu.wic.ssm.bean.Dept)
	 */
	public void modifyDept(Dept dept) {
		deptMapper.update(dept);
	}

	/** Title: findAllJob
	 * @see cn.edu.wic.ssm.Service.HRMService#findAllJob()
	 */
	public List<Job> findAllJob() {
		return jobMapper.selectAllJob();
	}

	/** Title: findJob
	 * @see cn.edu.wic.ssm.Service.HRMService#findJob(cn.edu.wic.ssm.bean.Job, cn.edu.wic.ssm.HrmTool.PageModel)
	 */
	public List<Job> findJob(Job job, PageModel pageModel) {
		/**当前需要分页的数据条数*/
		Map<String, Object>params = new HashMap<String, Object>();
		params.put("job", job);
		int recordCount = jobMapper.count(params);
		System.out.println("recordCount---->>"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0) {
			/**开始分页查询数据：查询第几页数据*/
			params.put("pageModel", pageModel);
		}
		return jobMapper.selectByPage(params);
	}

	/** Title: removeJobByid
	 * @see cn.edu.wic.ssm.Service.HRMService#removeJobByid(java.lang.Integer)
	 */
	public void removeJobByid(Integer id) {
		jobMapper.deleteByid(id);
	}

	/** Title: addJob
	 * @see cn.edu.wic.ssm.Service.HRMService#addJob(cn.edu.wic.ssm.bean.Job)
	 */
	public void addJob(Job job) {
		jobMapper.save(job);
	}

	/** Title: findJobByid
	 * @see cn.edu.wic.ssm.Service.HRMService#findJobByid(java.lang.Integer)
	 */
	public Job findJobByid(Integer id) {
		return jobMapper.selectById(id);
	}

	/** Title: modifyJob
	 * @see cn.edu.wic.ssm.Service.HRMService#modifyJob(cn.edu.wic.ssm.bean.Job)
	 */
	public void modifyJob(Job job) {
		jobMapper.update(job);
	}

	/** Title: findNotice
	 * @see cn.edu.wic.ssm.Service.HRMService#findNotice(cn.edu.wic.ssm.bean.Notice, cn.edu.wic.ssm.HrmTool.PageModel)
	 */
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		/**当前需要分页的数据条数*/
		Map<String, Object>params = new HashMap<String, Object>();
		params.put("notice", notice);
		int recordCount = noticeMapper.count(params);
		System.out.println("recordCount---->>"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0) {
			/**开始分页查询数据：查询第几页数据*/
			params.put("pageModel", pageModel);
		}
		return noticeMapper.selectByPage(params);
	}

	/** Title: findNoticeByid
	 * @see cn.edu.wic.ssm.Service.HRMService#findNoticeByid(java.lang.Integer)
	 */
	public Notice findNoticeByid(Integer id) {
		return noticeMapper.selectById(id);
	}

	/** Title: removeNoticeByid
	 * @see cn.edu.wic.ssm.Service.HRMService#removeNoticeByid(java.lang.Integer)
	 */
	public void removeNoticeByid(Integer id) {
		noticeMapper.deleteByid(id);
	}

	/** Title: addNotice
	 * @see cn.edu.wic.ssm.Service.HRMService#addNotice(cn.edu.wic.ssm.bean.Notice)
	 */
	public void addNotice(Notice notice) {
		noticeMapper.save(notice);
	}

	/** Title: modifyNotice
	 * @see cn.edu.wic.ssm.Service.HRMService#modifyNotice(cn.edu.wic.ssm.bean.Notice)
	 */
	public void modifyNotice(Notice notice) {
		noticeMapper.update(notice);
	}
}
