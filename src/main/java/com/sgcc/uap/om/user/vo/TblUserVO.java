package com.sgcc.uap.om.user.vo;

import java.io.Serializable;

import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;
/**
 * TblUser的VO类
 *
 * @author 87041 
 * @date 2018-09-06 09:52:28
 */
public class TblUserVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性用户编号
     */  
    @ViewAttribute(name ="userid",caption="用户编号", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String userid;    
    /** 
     * 属性用户表id主键
     */  
    @ViewAttribute(name ="id",caption="用户表id主键", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性用户昵称
     */  
    @ViewAttribute(name ="username",caption="用户昵称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String username;    
    /** 
     * 属性密码
     */  
    @ViewAttribute(name ="pw",caption="密码", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String pw;    
    /** 
     * 属性年龄
     */  
    @ViewAttribute(name ="age",caption="年龄", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String age;    
    /** 
     * 属性性别
     */  
    @ViewAttribute(name ="gender",caption="性别", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String gender;    
    /** 
     * 属性电话
     */  
    @ViewAttribute(name ="phone",caption="电话", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String phone;    
    /** 
     * 属性邮箱
     */  
    @ViewAttribute(name ="email",caption="邮箱", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String email;    
    /** 
     * 属性创建时间
     */  
    @ViewAttribute(name ="createdtime",caption="创建时间", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String createdtime;    
    /**
     * TblUserVO构造函数
     */
    public TblUserVO() {
        super();
    } 
   
	 /**
     * TblUserVO完整的构造函数
     */  
    public TblUserVO(String userid){
        this.userid = userid;
    }
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
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("USERID"+":"+getUserid())
				.append("ID"+":"+getId())
				.append("USERNAME"+":"+getUsername())
				.append("PW"+":"+getPw())
				.append("AGE"+":"+getAge())
				.append("GENDER"+":"+getGender())
				.append("PHONE"+":"+getPhone())
				.append("EMAIL"+":"+getEmail())
				.append("CREATEDTIME"+":"+getCreatedtime())
		        .toString(); 
			
    } 
   


}
