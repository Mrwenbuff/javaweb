package cn.edu.wic.ssm.mapper;

import static cn.edu.wic.ssm.HrmTool.HrmContants.JOBTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cn.edu.wic.ssm.bean.Job;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月17日 下午10:39:04
 * @version 1.0
 */
public class JobDynaSqlProvider {
	/**分页动态查询*/
		public String selectWithParam(final Map<String, Object>params) {
			String sql = new SQL() {
				{
					SELECT("*");
					FROM(JOBTABLE);
					if(params.get("job") !=null) {
						Job job = (Job) params.get("job");
						if(job.getName() !=null&& !job.getName().equals("")) {
							WHERE(" name like concat ('%',#{job.name},'%') ");
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
					FROM(JOBTABLE);
					if(params.get("job") !=null) {
						Job job = (Job) params.get("job");
						if(job.getName() !=null && !job.getName().equals("")) {
							WHERE( "  name like concat ('%',#{job.name},'%') ");
						}
					}
				}
			}.toString();
		}
		/**动态插入*/
			public String insertJob( final Job job) {
				String sql = new SQL() {
						{
							INSERT_INTO(JOBTABLE);
							if(job.getName()!=null && !job.getName().equals("")) {
								VALUES("name"," #{name}");
							}
							if(job.getRemark()!=null && !job.getRemark().equals("")) {
								VALUES("remark"," #{remark}");
							}
						}
					}.toString();
					return sql;
				}
			/**动态更新*/
			public String updateJob(final Job job) {
				return new SQL() {
					{
						UPDATE(JOBTABLE);
						if(job.getName()!=null) {
							SET(" name = #{name} ");
						}
						if(job.getRemark()!=null) {
							SET(" remark = #{remark} ");
						}
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
