package cn.edu.wic.ssm.mapper;

import static cn.edu.wic.ssm.HrmTool.HrmContants.JOBTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.edu.wic.ssm.bean.Job;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @date 创建时间：2018年6月17日 下午10:37:30
 * @version 1.0
 */
public interface JobMapper {
		/** 
		 * @Title: selectByPage 
		 * @Description: 分页动态查询
		 * @param params
		 * @return List<Job> 
		 * @throws 
		 */
		@SelectProvider(type=JobDynaSqlProvider.class,method="selectWithParam")
		List<Job> selectByPage(Map<String, Object>params);
		
		/** 
		 * @Title: count 
		 * @Description: 根据参数查询职位总数
		 * @param params
		 * @return Integer 
		 * @throws 
		 */
		@SelectProvider(type=JobDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object>params);
		
		/** 
		 * @Title: selectAllJob 
		 * @Description: 查询所有职位
		 * @param params
		 * @return List<Job> 
		 * @throws 
		 */
		@Select("select * from "+JOBTABLE+" ")
		List<Job> selectAllJob();
		
		/** 
		 * @Title: selectById 
		 * @Description: 根据id查询职位
		 * @param id
		 * @return Job 
		 * @throws 
		 */
		@Select("select * from" +JOBTABLE+" where id = #{id}")
		Job selectById(Integer id);
		
		/** 
		 * @Title: deleteByid 
		 * @Description: 根据id删除职位
		 * @param id void 
		 * @throws 
		 */
		@Delete(" delete from "+JOBTABLE+" where id = #{id}")
		void deleteByid(Integer id);
		
		/** 
		 * @Title: save 
		 * @Description: 动态插入职位
		 * @param job
		 * @return int 
		 * @throws 
		 */
		@SelectProvider(type=JobDynaSqlProvider.class,method="insertJob")
		int save(Job job);
		
		/** 
		 * @Title: update 
		 * @Description: 动态修改职位
		 * @param job
		 * @return int 
		 * @throws 
		 */
		@SelectProvider(type=JobDynaSqlProvider.class,method="updateJob")
		int update(Job job);
}
