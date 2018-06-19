package cn.edu.wic.ssm.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable{
	
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date creatdate;

    /**
     * 登录名
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态
     */
    private Boolean status;

    /**
     * 用户名
     */
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}