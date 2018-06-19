package cn.edu.wic.ssm.mapper;

import static cn.edu.wic.ssm.HrmTool.HrmContants.EMPLOYEETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cn.edu.wic.ssm.bean.Dept;
import cn.edu.wic.ssm.bean.Employee;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月18日 下午2:48:59
 * @version 1.0
 */
public class EmployeeDynaSqlProvider {
	/**分页动态查询*/
		public String selectWithParam(final Map<String, Object>params) {
			String sql = new SQL() {
				{
					SELECT("*");
					FROM(EMPLOYEETABLE);
					if(params.get("employee") !=null) {
						Employee employee = (Employee) params.get("employee");
						if(employee.getDept() !=null&& employee.getDept().getId() !=null && employee.getDept().getId() !=0) {
							WHERE("  deptId = #{employee.dept.id}  ");
						}
						if(employee.getJob() !=null&& employee.getJob().getId() != null && employee.getJob().getId() != 0) {
							WHERE("  jobId =  #{employee.job.id} ");
						}
						if(employee.getName() !=null&& !employee.getName().equals("")) {
							WHERE(" name like concat ('%',#{employee.name},'%') ");
						}
						if(employee.getPhone() !=null&& !employee.getPhone().equals("")) {
							WHERE(" phone like concat ('%',#{employee.phone},'%') ");
						}
						if(employee.getCardid() !=null&& !employee.getCardid().equals("")) {
							WHERE(" cardId like concat ('%',#{employee.cardid},'%') ");
						}
						if(employee.getSex() !=null&& employee.getSex() !=0) {
							WHERE("  sex = #{employee.sex} ");
						}
					}
				}
			}.toString();
			
			if(params.get("pageModel") !=null) {
				sql += " limit #{pageModel.fristLimitParam} , #{pageModel.pageSize}  ";
			}
			return sql;
		}
		/**动态查询总数量*/
		public String count(final Map<String, Object>params) {
			return new SQL() {
				{
					SELECT("count(*)");
					FROM(EMPLOYEETABLE);
					if(params.get("employee") !=null) {
						Employee employee = (Employee) params.get("employee");
						if(employee.getCardid() !=null&& !employee.getCardid().equals("")) {
							WHERE(" cardId like concat ('%',#{employee.cardid},'%') ");
						}
					}
				}
			}.toString();
		}
		/**动态插入*/
			public String insertEmployee( final Employee employee) {
				String sql = new SQL() {
						{
							INSERT_INTO(EMPLOYEETABLE);
							if(employee.getName()!=null && !employee.getName().equals("")) {
								VALUES("name"," #{name}");
							}
							if(employee.getCardid()!=null && !employee.getCardid().equals("")) {
								VALUES("cardId"," #{cardid}");
							}
							if(employee.getAddress()!=null && !employee.getAddress().equals("")) {
								VALUES("address"," #{address}");
							}
							if(employee.getPostcode()!=null && !employee.getPostcode().equals("")) {
								VALUES("postCode"," #{postcode}");
							}
							if(employee.getTel()!=null && !employee.getTel().equals("")) {
								VALUES("tel"," #{tel}");
							}
							if(employee.getPhone()!=null && !employee.getPhone().equals("")) {
								VALUES("phone"," #{phone}");
							}
							if(employee.getQq()!=null && !employee.getQq().equals("")) {
								VALUES("qq"," #{qq}");
							}
							if(employee.getEmail()!=null && !employee.getEmail().equals("")) {
								VALUES("email"," #{email}");
							}
							if(employee.getSex()!=null && !employee.getSex().equals("")) {
								VALUES("sex"," #{sex}");
							}
							if(employee.getParty()!=null && !employee.getParty().equals("")) {
								VALUES("party"," #{party}");
							}
							if(employee.getBirthday()!=null && !employee.getBirthday().equals("")) {
								VALUES("birthday"," #{birthday}");
							}
							if(employee.getRace()!=null && !employee.getRace().equals("")) {
								VALUES("race"," #{race}");
							}
							if(employee.getEducation()!=null && !employee.getEducation().equals("")) {
								VALUES("education"," #{education}");
							}
							if(employee.getHobby()!=null && !employee.getHobby().equals("")) {
								VALUES("hobby"," #{hobby}");
							}
							if(employee.getRemark()!=null && !employee.getRemark().equals("")) {
								VALUES("remark"," #{remark}");
							}
							if(employee.getSpeciality()!=null && !employee.getSpeciality().equals("")) {
								VALUES("speciality"," #{speciality}");
							}
							if(employee.getCreatedate()!=null && !employee.getCreatedate().equals("")) {
								VALUES("createDate"," #{createdate}");
							}
							if(employee.getDeptid()!=null && !employee.getDeptid().equals("")) {
								VALUES("deptId"," #{deptid}");
							}
							if(employee.getJobid()!=null && !employee.getJobid().equals("")) {
								VALUES("jobId"," #{jobid}");
							}
						}
					}.toString();
					return sql;
				}
			/**动态更新*/
			public String updateEmployee(final Employee employee) {
				return new SQL() {
					{
						UPDATE(EMPLOYEETABLE);
						if(employee.getName()!=null) {
							SET(" name = #{name} ");
						}
						if(employee.getCardid()!=null) {
							SET(" cardId = #{cardid} ");
						}
						if(employee.getAddress()!=null) {
							SET(" address = #{address} ");
						}
						if(employee.getPostcode()!=null) {
							SET(" postCode = #{postcode} ");
						}
						if(employee.getTel()!=null) {
							SET(" tel = #{tel} ");
						}
						if(employee.getPhone()!=null) {
							SET(" phone = #{phone} ");
						}
						if(employee.getQq()!=null) {
							SET(" qq = #{qq} ");
						}
						if(employee.getEmail()!=null) {
							SET(" email = #{email} ");
						}
						if(employee.getSex()!=null) {
							SET(" sex = #{sex} ");
						}
						if(employee.getParty()!=null) {
							SET(" party = #{party} ");
						}
						if(employee.getBirthday()!=null) {
							SET(" birthday = #{birthday} ");
						}
						if(employee.getRace()!=null) {
							SET(" race = #{race} ");
						}
						if(employee.getEducation()!=null) {
							SET(" education = #{education} ");
						}
						if(employee.getHobby()!=null) {
							SET(" hobby = #{hobby} ");
						}
						if(employee.getRemark()!=null) {
							SET(" remark = #{remark} ");
						}
						if(employee.getSpeciality()!=null) {
							SET(" speciality = #{speciality} ");
						}
						if(employee.getCreatedate()!=null) {
							SET(" createDate = #{createdate} ");
						}
						if(employee.getDeptid()!=null) {
							SET(" deptId = #{deptid} ");
						}
						if(employee.getJobid()!=null) {
							SET(" jobId = #{jobid} ");
						}
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
