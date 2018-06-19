package cn.edu.wic.ssm.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Document {
	
	/**
	 * 文件
	 */
	private MultipartFile file;
	
	/**
	 * 上传人
	 */
	private User user;
	
    /**
     * 文档id
     */
    private Integer id;
    
    /**
     * 文档标题
     */
    private String title;
    
    /**
     * 文件名
     */
    private String filename;

    /**
     * 详细描述
     */
    private String remark;

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}