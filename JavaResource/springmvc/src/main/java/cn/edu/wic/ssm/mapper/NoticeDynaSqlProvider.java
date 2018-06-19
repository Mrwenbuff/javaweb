package cn.edu.wic.ssm.mapper;

import static cn.edu.wic.ssm.HrmTool.HrmContants.NOTICETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cn.edu.wic.ssm.bean.Notice;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月17日 下午10:52:27
 * @version 1.0
 */
public class NoticeDynaSqlProvider {
	/**分页动态查询*/
		public String selectWithParam(final Map<String, Object>params) {
			String sql = new SQL() {
				{
					SELECT("*");
					FROM(NOTICETABLE);
					if(params.get("notice") !=null) {
						Notice notice = (Notice) params.get("notice");
						if(notice.getTitle() !=null&& !notice.getTitle().equals("")) {
							WHERE(" title like concat ('%',#{notice.title},'%') ");
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
					FROM(NOTICETABLE);
					if(params.get("notice") !=null) {
						Notice notice = (Notice) params.get("notice");
						if(notice.getTitle() !=null && !notice.getTitle().equals("")) {
							WHERE( "  title like concat ('%',#{notice.title},'%') ");
						}
						if(notice.getContent() !=null && !notice.getContent().equals("")) {
							WHERE( "  content like concat ('%',#{notice.content},'%') ");
						}
					}
				}
			}.toString();
		}
		/**动态插入*/
			public String insertNotice( final Notice notice) {
				String sql = new SQL() {
						{
							INSERT_INTO(NOTICETABLE);
							if(notice.getTitle()!=null && !notice.getTitle().equals("")) {
								VALUES("title"," #{title}");
							}
							if(notice.getContent()!=null && !notice.getContent().equals("")) {
								VALUES("content"," #{content}");
							}
							if(notice.getUserid()!=null && !notice.getUserid().equals("")) {
								VALUES("userId"," #{userid}");
							}
						}
					}.toString();
					return sql;
				}
			/**动态更新*/
			public String updateNotice(final Notice notice) {
				return new SQL() {
					{
						UPDATE(NOTICETABLE);
						if(notice.getTitle()!=null) {
							SET(" title = #{title} ");
						}
						if(notice.getContent()!=null) {
							SET(" content = #{content} ");
						}
						if(notice.getUser()!=null && notice.getUser().getId() !=null) {
							SET(" userId = #{userid} ");
						}
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
