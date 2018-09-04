package com.sgcc.uap.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.sgcc.uap.domain.Student;

/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 87041
 * @date 2018-09-02 12:39:46
 * @since 1.0
 */
public interface StudentRepository extends JpaRepository<Student,String>,JpaSpecificationExecutor<Student> {

	//pojo查询部分字段
	@Query("Select new Student(b.sname,b.sno) from Student b where b.sno =?1")
	List<Student> getStudentBySno(String sno);
	//分页
	@Query(value ="Select   new Student(b.sname,b.sno)  from Student b where son = ?2 ")
	Page<Student> getStudentByAll(Pageable page);
	//原生SQL进行查询 返回值 Object
	@Query(value ="select  b.sname,b.sno from student b  left join    ", nativeQuery=true)
	 List<Object> getMapByAll();
	// 级联查询 需要转一下类型，
	@Query(value = "select  b.sname,a.classno from student b "
	+ "inner join sclass a on a.classno = b.studentclass "
    + " where 1 =1",nativeQuery = true)
List<Object> getByUserId();
	
}
