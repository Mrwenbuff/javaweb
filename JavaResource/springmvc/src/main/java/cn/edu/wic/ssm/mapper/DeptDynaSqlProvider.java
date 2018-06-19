package cn.edu.wic.ssm.mapper;

import  static cn.edu.wic.ssm.HrmTool.HrmContants.DEPTTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cn.edu.wic.ssm.bean.Dept;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月17日 下午9:54:04
 * @version 1.0
 */
public class DeptDynaSqlProvider {
	
	/**分页动态查询*/
	public String selectWithParam(final Map<String, Object>params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(DEPTTABLE);
				if(params.get("dept") !=null) {
					Dept dept = (Dept) params.get("dept");
					if(dept.getName() !=null&& !dept.getName().equals("")) {
						WHERE(" name like concat ('%',#{dept.name},'%') ");
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
				FROM(DEPTTABLE);
				if(params.get("dept") !=null) {
					Dept dept = (Dept) params.get("dept");
					if(dept.getName() !=null && !dept.getName().equals("")) {
						WHERE( "  name like concat ('%',#{dept.name},'%') ");
					}
				}
			}
		}.toString();
	}
	/**动态插入*/
		public String insertDept( final Dept dept) {
			String sql = new SQL() {
					{
						INSERT_INTO(DEPTTABLE);
						if(dept.getName()!=null && !dept.getName().equals("")) {
							VALUES("name"," #{name}");
						}
						if(dept.getRemark()!=null && !dept.getRemark().equals("")) {
							VALUES("remark"," #{remark}");
						}
					}
				}.toString();
				return sql;
			}
		/**动态更新*/
		public String updateDept(final Dept dept) {
			return new SQL() {
				{
					UPDATE(DEPTTABLE);
					if(dept.getName()!=null) {
						SET(" name = #{name} ");
					}
					if(dept.getRemark()!=null) {
						SET(" remark = #{remark} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
