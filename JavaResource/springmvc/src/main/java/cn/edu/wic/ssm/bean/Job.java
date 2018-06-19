package cn.edu.wic.ssm.bean;

import java.io.Serializable;

public class Job implements Serializable{
	
    /**
     * 职位id
     */
    private Integer id;

    /**
     * 职位名称
     */
    private String name;

    /**
     * 职位描述
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}