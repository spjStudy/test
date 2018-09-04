package com.sgcc.uap.vo;


import com.sgcc.uap.domain.Student;

public class StudentTransfer {

	public static Student toPO(StudentVO vo) {
		Student student = new Student();
		if(vo != null){
			student.setSno(vo.getSno());
			student.setSname(vo.getSname());
			student.setSsex(vo.getSsex());
			student.setSbirthday(vo.getSbirthday());
			student.setStudentclass(vo.getStudentclass());
        }
		return student;
	}

	public static StudentVO toVO(Student po) {
		StudentVO vo = new StudentVO();
		vo.setSno(po.getSno());
		vo.setSname(po.getSname());
		vo.setSsex(po.getSsex());
		vo.setSbirthday(po.getSbirthday());
		vo.setStudentclass(po.getStudentclass());
		return vo;
	}
}
