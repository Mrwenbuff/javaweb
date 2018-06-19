package cn.edu.wic.ssm.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Notice implements Serializable{
	
	/**
	 * 发布人
	 */
	private User user;
	
    /**
     * 公告编号
     */
    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    /**
     * 发布人id
     */
    private Integer userid;

    /**
     * 公告内容
     */
    private String content;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}