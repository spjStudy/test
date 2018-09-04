package com.sgcc.uap.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Student的POJO类
 *
 * @author 87041 
 * @date 2018-09-02 12:39:46
 */
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;
	public Student(){}
	public Student(String sno,String sname){
		
		super();
		this.sname = sname;
		this.sno = sno;
	}
    /** 
     * SNO
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "SNO", nullable = false, length = 255)
    private String sno ;
    
    /** 
     * SNAME
     */
    @Column(name = "SNAME", nullable = false, length = 255)
    private String sname ;
    
    /** 
     * SSEX
     */
    @Column(name = "SSEX", nullable = false, length = 255)
    private String ssex ;
    
    /** 
     * SBIRTHDAY
     */
    @Column(name = "SBIRTHDAY", nullable = true, length = 255)
    private String sbirthday ;
    
    /** 
     * STUDENTCLASS
     */
    @Column(name = "STUDENTCLASS", nullable = true, length = 255)
    private String studentclass ;
    
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
     * Hibernate通过该方法判断对象是否相等
     * @return boolean
     */  
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		
        if (obj == null || !(obj instanceof Student))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		Student other = (Student) obj;
		
		if (sno == null) {
			if (other.sno != null) {
				return false;
			}
		} else if (!sno.equals(other.sno)) {
			return false;
		}
		if (sname == null) {
			if (other.sname != null) {
				return false;
			}
		} else if (!sname.equals(other.sname)) {
			return false;
		}
		if (ssex == null) {
			if (other.ssex != null) {
				return false;
			}
		} else if (!ssex.equals(other.ssex)) {
			return false;
		}
		if (sbirthday == null) {
			if (other.sbirthday != null) {
				return false;
			}
		} else if (!sbirthday.equals(other.sbirthday)) {
			return false;
		}
		if (studentclass == null) {
			if (other.studentclass != null) {
				return false;
			}
		} else if (!studentclass.equals(other.studentclass)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "Student ["
			+ ", sno=" + sno
			+ ", sname=" + sname
			+ ", ssex=" + ssex
			+ ", sbirthday=" + sbirthday
			+ ", studentclass=" + studentclass;
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