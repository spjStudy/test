package com.sgcc.uap.vo;

import java.io.Serializable;

import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;
/**
 * Student的VO类
 *
 * @author 87041 
 * @date 2018-09-02 12:39:46
 */
public class StudentVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性SNO
     */  
    @ViewAttribute(name ="sno",caption="SNO", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String sno;    
    /** 
     * 属性SNAME
     */  
    @ViewAttribute(name ="sname",caption="SNAME", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String sname;    
    /** 
     * 属性SSEX
     */  
    @ViewAttribute(name ="ssex",caption="SSEX", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String ssex;    
    /** 
     * 属性SBIRTHDAY
     */  
    @ViewAttribute(name ="sbirthday",caption="SBIRTHDAY", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String sbirthday;    
    /** 
     * 属性STUDENTCLASS
     */  
    @ViewAttribute(name ="studentclass",caption="STUDENTCLASS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String studentclass;    
    /**
     * StudentVO构造函数
     */
    public StudentVO() {
        super();
    } 
   
	 /**
     * StudentVO完整的构造函数
     */  
    public StudentVO(String sno){
        this.sno = sno;
    }
    /**
     * SNO的get方法
     * @return sno
     */
    public String getSno(){
        return sno;
    }
    /**
     * SNO的set方法
     * @param sno
     */
    public void setSno(String sno){
        if(sno != null && sno.trim().length() == 0){
        	this.sno = null;
        }else{
        	this.sno = sno;
        }
	} 
    /**
     * SNAME的get方法
     * @return sname
     */
    public String getSname(){
        return sname;
    }
    /**
     * SNAME的set方法
     * @param sname
     */
    public void setSname(String sname){
		this.sname = sname;
	} 
    /**
     * SSEX的get方法
     * @return ssex
     */
    public String getSsex(){
        return ssex;
    }
    /**
     * SSEX的set方法
     * @param ssex
     */
    public void setSsex(String ssex){
		this.ssex = ssex;
	} 
    /**
     * SBIRTHDAY的get方法
     * @return sbirthday
     */
    public String getSbirthday(){
        return sbirthday;
    }
    /**
     * SBIRTHDAY的set方法
     * @param sbirthday
     */
    public void setSbirthday(String sbirthday){
		this.sbirthday = sbirthday;
	} 
    /**
     * STUDENTCLASS的get方法
     * @return studentclass
     */
    public String getStudentclass(){
        return studentclass;
    }
    /**
     * STUDENTCLASS的set方法
     * @param studentclass
     */
    public void setStudentclass(String studentclass){
		this.studentclass = studentclass;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("SNO"+":"+getSno())
				.append("SNAME"+":"+getSname())
				.append("SSEX"+":"+getSsex())
				.append("SBIRTHDAY"+":"+getSbirthday())
				.append("STUDENTCLASS"+":"+getStudentclass())
		        .toString(); 
			
    } 
   


}
