package cn.edu.wic.ssm.mapper;

import static cn.edu.wic.ssm.HrmTool.HrmContants.NOTICETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.edu.wic.ssm.bean.Notice;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月17日 下午10:51:02
 * @version 1.0
 */
public interface NoticeMapper {
		/** 
		 * @Title: selectByPage 
		 * @Description: 分页动态查询
		 * @param params
		 * @return List<Notice> 
		 * @throws 
		 */
		@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectWithParam")
		List<Notice> selectByPage(Map<String, Object>params);
		
		/** 
		 * @Title: count 
		 * @Description: 根据参数查询公告总数
		 * @param params
		 * @return Integer 
		 * @throws 
		 */
		@SelectProvider(type=NoticeDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object>params);
		
		/** 
		 * @Title: selectAllNotice 
		 * @Description: 查询所有公告
		 * @param params
		 * @return List<Notice> 
		 * @throws 
		 */
		@Select("select * from "+NOTICETABLE+" ")
		List<Notice> selectAllNotice(Map<String, Object>params);
		
		/** 
		 * @Title: selectById 
		 * @Description: 根据id查询
		 * @param id
		 * @return Notice 
		 * @throws 
		 */
		@Select("select * from" +NOTICETABLE+" where id = #{id}")
		Notice selectById(Integer id);
		
		/** 
		 * @Title: deleteByid 
		 * @Description: 根据id删除公告
		 * @param id void 
		 * @throws 
		 */
		@Delete(" delete from "+NOTICETABLE+" where id = #{id}")
		void deleteByid(Integer id);
		
		/** 
		 * @Title: save 
		 * @Description: 动态插入部门
		 * @param notice
		 * @return int 
		 * @throws 
		 */
		@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
		int save(Notice notice);
		
		/** 
		 * @Title: update 
		 * @Description: 动态修改公告
		 * @param notice
		 * @return int 
		 * @throws 
		 */
		@SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
		int update(Notice notice);
}
