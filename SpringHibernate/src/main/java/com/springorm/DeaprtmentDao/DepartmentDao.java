package com.springorm.DeaprtmentDao;

import java.util.List;

import com.springorm.entity.Department;

public interface DepartmentDao {
	public int insertDepartment(Department dept);

	public int updateDepartment(Department dept);

	public int deleteDepartment(Department dept);

	public Department getDepartment(int id);

	public List<Department> getAllDepartments();

}
