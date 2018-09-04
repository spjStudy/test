//package com.sgcc.uap.services;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import com.sgcc.uap.domain.Student;
//import com.sgcc.uap.repositories.StudentRepository;
//
///**
// * <b>概述</b>：<br>
// * TODO
// * <p>
// * <b>功能</b>：<br>
// * TODO
// *
// * @author 87041
// * @date 2018-09-02 12:39:46
// * @since 1.0
// */
//@Service
//public class StudentService  implements IStudentService{
//	@Autowired
//	private StudentRepository studentRepository;
//
//	@Override
//	public Page<Student> findByPageAndParams(String sno, Pageable pageable) {
//		Specification<T> paramSpecification = new Specification<T>() {
//
//			@Override
//			public Predicate toPredicate(Root<T> paramRoot, CriteriaQuery<?> paramCriteriaQuery,
//					CriteriaBuilder paramCriteriaBuilder) { 
//				
//				
//			}
//		};
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//	
//}
