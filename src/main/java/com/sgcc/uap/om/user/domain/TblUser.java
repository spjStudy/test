package com.sgcc.uap.om.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TblUser的POJO类
 *
 * @author 87041 
 * @date 2018-09-05 09:15:50
 */
@Entity
@Table(name = "TBL_USER")
public class TblUser implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * 用户编号
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "assiged")
    @Column(name = "USERID", nullable = false, length = 20)
    private String userid ;
    
    /** 
     * 用户表id主键
     */
    @Column(name = "ID", nullable = false, length = 50)
    private String id ;
    
    /** 
     * 用户昵称
     */
    @Column(name = "USERNAME", nullable = true, length = 50)
    private String username ;
    
    /** 
     * 密码
     */
    @Column(name = "PW", nullable = true, length = 20)
    private String pw ;
    
    /** 
     * 年龄
     */
    @Column(name = "AGE", nullable = true, length = 50)
    private String age ;
    
    /** 
     * 性别
     */
    @Column(name = "GENDER", nullable = true, length = 255)
    private String gender ;
    
    /** 
     * 电话
     */
    @Column(name = "PHONE", nullable = true, length = 20)
    private String phone ;
    
    /** 
     * 邮箱
     */
    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email ;
    
    /** 
     * 创建时间
     */
    @Column(name = "CREATEDTIME", nullable = true, length = 50)
    private String createdtime ;
    
    /**
     * 用户编号的get方法
     * @return userid
     */
    public String getUserid(){
        return userid;
    }
    /**
     * 用户编号的set方法
     * @param userid
     */
    public void setUserid(String userid){
        if(userid != null && userid.trim().length() == 0){
        	this.userid = null;
        }else{
        	this.userid = userid;
        }
	} 
    /**
     * 用户表id主键的get方法
     * @return id
     */
    public String getId(){
        return id;
    }
    /**
     * 用户表id主键的set方法
     * @param id
     */
    public void setId(String id){
		this.id = id;
	} 
    /**
     * 用户昵称的get方法
     * @return username
     */
    public String getUsername(){
        return username;
    }
    /**
     * 用户昵称的set方法
     * @param username
     */
    public void setUsername(String username){
		this.username = username;
	} 
    /**
     * 密码的get方法
     * @return pw
     */
    public String getPw(){
        return pw;
    }
    /**
     * 密码的set方法
     * @param pw
     */
    public void setPw(String pw){
		this.pw = pw;
	} 
    /**
     * 年龄的get方法
     * @return age
     */
    public String getAge(){
        return age;
    }
    /**
     * 年龄的set方法
     * @param age
     */
    public void setAge(String age){
		this.age = age;
	} 
    /**
     * 性别的get方法
     * @return gender
     */
    public String getGender(){
        return gender;
    }
    /**
     * 性别的set方法
     * @param gender
     */
    public void setGender(String gender){
		this.gender = gender;
	} 
    /**
     * 电话的get方法
     * @return phone
     */
    public String getPhone(){
        return phone;
    }
    /**
     * 电话的set方法
     * @param phone
     */
    public void setPhone(String phone){
		this.phone = phone;
	} 
    /**
     * 邮箱的get方法
     * @return email
     */
    public String getEmail(){
        return email;
    }
    /**
     * 邮箱的set方法
     * @param email
     */
    public void setEmail(String email){
		this.email = email;
	} 
    /**
     * 创建时间的get方法
     * @return createdtime
     */
    public String getCreatedtime(){
        return createdtime;
    }
    /**
     * 创建时间的set方法
     * @param createdtime
     */
    public void setCreatedtime(String createdtime){
		this.createdtime = createdtime;
	} 
    /**
     * Hibernate通过该方法判断对象是否相等
     * @return boolean
     */  
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		
        if (obj == null || !(obj instanceof TblUser))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		TblUser other = (TblUser) obj;
		
		if (userid == null) {
			if (other.userid != null) {
				return false;
			}
		} else if (!userid.equals(other.userid)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		if (pw == null) {
			if (other.pw != null) {
				return false;
			}
		} else if (!pw.equals(other.pw)) {
			return false;
		}
		if (age == null) {
			if (other.age != null) {
				return false;
			}
		} else if (!age.equals(other.age)) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (createdtime == null) {
			if (other.createdtime != null) {
				return false;
			}
		} else if (!createdtime.equals(other.createdtime)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "TblUser ["
			+ ", userid=" + userid
			+ ", id=" + id
			+ ", username=" + username
			+ ", pw=" + pw
			+ ", age=" + age
			+ ", gender=" + gender
			+ ", phone=" + phone
			+ ", email=" + email
			+ ", createdtime=" + createdtime;
	}
   
    
    /**
     * hashcode方法
     * @return int
     * 
     */
    @Override
    public int hashCode(){
		return super.hashCode();
	}
}