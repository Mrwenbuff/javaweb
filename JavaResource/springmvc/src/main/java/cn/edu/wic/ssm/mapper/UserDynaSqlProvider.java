package cn.edu.wic.ssm.mapper;
/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月17日 下午5:49:32
 * @version 1.0
 */
import  static cn.edu.wic.ssm.HrmTool.HrmContants.USERTABLE ;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cn.edu.wic.ssm.bean.User;

public class UserDynaSqlProvider {
	/**动态分页查询*/
	public String selectWithUser(Map<String, Object>params) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from ")
		.append(USERTABLE);
		if(params.get("user") !=null) {
			User user = (User) params.get("user");
			if(user.getUsername() !=null && !user.getUsername().equals("")) {
				sql.append(" where username like concat('%',#{user.username},'%') ");
			}
		}
		if(params.get("pageModel") != null) {
			sql.append(" limit #{pageModel.fristLimitParam} , #{pageModel.pageSize} ");
		}
		return sql.toString();
	}
	/**动态查询总数量*/
	public String count(Map<String, Object>params) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) from ")
		.append(USERTABLE);
		if(params.get("user") !=null) {
			User user = (User) params.get("user");
			if(user.getUsername() !=null && !user.getUsername().equals("")) {
				sql.append(" where username like concat('%',#{user.username},'%') ");
			}
		}
		return sql.toString();
	}
	/**动态插入*/
	public String insertUser( final User user) {
		String sql = new SQL() {
				{
					INSERT_INTO(USERTABLE);
					if(user.getUsername()!=null && !user.getUsername().equals("")) {
						VALUES("username"," #{username}");
					}
					if(user.getStatus()!=null && !user.getStatus().equals("")) {
						VALUES("status"," #{status}");
					}
					if(user.getLoginname()!=null && !user.getLoginname().equals("")) {
						VALUES("loginname"," #{loginname}");
					}
					if(user.getPassword()!=null && !user.getPassword().equals("")) {
						VALUES("password"," #{password}");
					}
				}
		
			}.toString();
			return sql;
		}
	/**动态更新*/
	public String updateUser(final User user) {
		return new SQL() {
			{
				UPDATE(USERTABLE);
				if(user.getUsername()!=null) {
					SET("username = #{username}");
				}
				if(user.getStatus()!=null) {
					SET("status = #{status}");
				}
				if(user.getLoginname()!=null) {
					SET("loginname = #{loginname}");
				}
				if(user.getPassword()!=null) {
					SET("password = #{password}");
				}
				if(user.getCreatdate()!=null) {
					SET("creadDate = #{createdate}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}
