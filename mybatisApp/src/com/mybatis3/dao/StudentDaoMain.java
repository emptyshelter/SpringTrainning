package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentById-------");
		System.out.println(studentDao.findStudentById(1));
		System.out.println(studentDao.findStudentById(2));
		System.out.println("---------findAllStudents---------");
		System.out.println(studentDao.findAllStudents());
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println("###"+studentDao.findStudentByIdResultMap(2));
		System.out.println("---------findStudentByIdWithAddress----------");
		System.out.println("###"+studentDao.findAllStudentsResultMap());
//		System.out.println("---------insertStudent(Dto)--------------");
//		Student insertStudent = new Student(9000, "김추천", "k_recommend@gmail.com", new Date());
//		System.out.println("####"+studentDao.insertStudent(insertStudent));
//		System.out.println("---------insertStudentBySequence1---------");
//		Student insertStudent2 = new Student(0, "김천천", "k_slow@gmail.com", new Date(2020-1900,1,18));
//		System.out.println("####"+studentDao.insertStudentBySequence1(insertStudent2));
//		System.out.println("---------insertStudentBySequence2---------");
		Student insertStudent3 = new Student(0, "김천", "k_thousand@gmail.com", new Date(2020-1900,1,18));
//		System.out.println("####"+studentDao.insertStudentBySequence2(insertStudent3));
		insertStudent3.setName("김백");
		insertStudent3.setEmail("k_hundred@gmail.com");
		insertStudent3.setDob(new Date());;
		System.out.println("---------updateStudent-------------------");
		System.out.println("update-->"+studentDao.updateStudent(insertStudent3));
////		
//		System.out.println("---------delete Student By Id------------------");
//		System.out.println("deleteById-->"+studentDao.deleteStudentById(3));
//		System.out.println("### "+studentDao.deleteStudentById(insertStudent3.getStudId()));

//		System.out.println("---------delete Student By Name------------------");
//		System.out.println("deleteByName-->"+studentDao.deleteStudentByName("김천"));
		
		/*
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------insertStudentParameterMap(parameter Map)----");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");
		*/

	}
}
