package com.springorm.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.DeaprtmentDao.DepartmentDao;
import com.springorm.entity.Department;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentDao ddao = (DepartmentDao) ac.getBean("dptdao");
		Department dept = new Department(100, "Admin");
		Department dept1 = new Department(200, "Training");
		Department dept2 = new Department(300, "Academic Excellence");

		ddao.insertDepartment(dept);
		ddao.insertDepartment(dept1);
		ddao.insertDepartment(dept2);

		// dept = ddao.getDepartment(100);

		// ddao.updateDepartment(dept2);
		// ddao.deleteDepartment(dept2);

		List<Department> dlist = ddao.getAllDepartments();

		System.out.println(dlist);

	}
}
