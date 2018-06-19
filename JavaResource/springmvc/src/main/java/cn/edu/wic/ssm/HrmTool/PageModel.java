package cn.edu.wic.ssm.HrmTool;
/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @Description:  分页模型
 * @date 创建时间：2018年6月18日 下午3:34:31
 * @version 1.0
 */
public class PageModel {
	/**
	 * 分页总条数数据
	 */
	private int recordCount;
	
	/**
	 * 当前页数
	 */
	private int pageIndex;
	
	/**
	 * 每页分多少数据
	 */
	private int pageSize = HrmContants.PAGE_SIZE;
	
	/**
	 * 总页数
	 */
	private int totalSize;
	
	/**
	 * @return 分页总条数
	 */
	public int getRecordCount() {
		this.recordCount = this.recordCount <=0 ? 0 : this.recordCount;
		return recordCount;
	}

	/**
	 * @param recordCount
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
	/**
	 * @return 当前页数
	 */
	public int getPageIndex() {
		this.pageIndex = this.pageIndex <= 0 ? 1 : this.pageIndex;
		/**判断当前页是否超过总页数， 如果超过，默认将最后一页作为当前页*/
		this.pageIndex = this.pageIndex >= this.getTotalSize() ? this.getTotalSize() : this.pageIndex;
		return pageIndex;
	}

	/**
	 * @param pageIndex
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return 每页分多少数据
	 */
	public int getPageSize() {
		/**  获取每页分得数据数， 数据数不小于默认分页数据数*/
		this.pageSize = this.pageSize <= HrmContants.PAGE_SIZE ? HrmContants.PAGE_SIZE : this.pageSize;
		return pageSize;
	}

	/**
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return 总页数
	 */
	public int getTotalSize() {
		if( this.getRecordCount() <= 0) {
			totalSize = 0;
		}else {
			totalSize = (this.getRecordCount()-1) / this.getPageSize() +1;
		}
		return totalSize;
	}

	/**
	 * @return 初始化分页数据
	 */
	public int getFirstLimitParam() {
		return (this.getPageIndex() -1 ) * this.getPageSize();
	}

}
