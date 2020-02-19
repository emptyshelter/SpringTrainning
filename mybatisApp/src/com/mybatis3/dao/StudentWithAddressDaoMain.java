package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentWithAddressDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
//		System.out.println("#######"+studentDao.findStudentsByIdWithAddressResultMap(3));
		System.out.println("####"+studentDao.findStudentsByIdWithAddressNestedSelectResultMap(3));

	}
}
