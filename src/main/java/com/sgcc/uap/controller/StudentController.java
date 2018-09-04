package com.sgcc.uap.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgcc.uap.domain.Student;
import com.sgcc.uap.repositories.StudentRepository;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.WrappedResult; 

/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 87041
 * @date 2018-09-02 12:39:46
 * @since 1.0
 */
@RestController
@Transactional
@RequestMapping("/student")
public class StudentController {
	private final static Logger logger = (Logger) LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentRepository studentRepository;
	/**
	 * 根据id查询
	 * @param id
	 * @return 查询结果
	 */
	@RequestMapping(value = "/{sno}")
	public List<Student> getBySno(@PathVariable String sno) {
		return studentRepository.getStudentBySno(sno);
	}
	@RequestMapping(value = "/all")
	public Page<Student> getByAll() {
		 Pageable pageable = new PageRequest(1, 2, Sort.Direction.DESC, "sno");
		return studentRepository.getStudentByAll( pageable);
	}
	@RequestMapping(value = "/map")
	public List<Object> getByMapAll() {
		return studentRepository.getMapByAll( );
	}
	@RequestMapping(value = "/student/{sno}")
	public List<Object> getByStudent(@PathVariable String sno) {
		System.out.println("你好github");
		return studentRepository.getByUserId();
	}
}
