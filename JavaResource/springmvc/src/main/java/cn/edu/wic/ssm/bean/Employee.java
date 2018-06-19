package cn.edu.wic.ssm.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee implements Serializable{
	
	/**
	 * 员工关联的部门对象
	 */
	private Dept dept;
	
	/**
	 * 员工关联的职位对象
	 */
	private Job job;
	
    /**
     * 员工id
     */
    private Integer id;

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdate;

    /**
     * 身份证编号
     */
    private Integer cardid;

    /**
     * 部门编号
     */
    private Integer deptid;

    /**
     * 职位编号
     */
    private Integer jobid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮政编码
     */
    private String postcode;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 住宅电话
     */
    private String tel;

    /**
     * 手机号
     */
    private String phone;

    /**
     * QQ号
     */
    private String qq;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 政治面貌
     */
    private String party;

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    /**
     * 民族
     */
    private String race;

    /**
     * 学历
     */
    private String education;
    
    /**
     * 专业
     */
    private String speciality;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party == null ? null : party.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race == null ? null : race.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
    
}