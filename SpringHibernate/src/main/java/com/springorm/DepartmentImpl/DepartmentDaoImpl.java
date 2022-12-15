package com.springorm.DepartmentImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.DeaprtmentDao.DepartmentDao;
import com.springorm.entity.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	private HibernateTemplate ht;

	// To insert record of department
	@Transactional
	public int insertDepartment(Department dept) {
		int id = (int) ht.save(dept);
		return 1;

	}

	// To update record of department
	@Transactional
	public int updateDepartment(Department dept) {
		ht.update(dept);
		return 1;

	}

	// To delete record of department
	@Transactional
	public int deleteDepartment(Department dept) {
		ht.delete(dept);
		return 1;

	}

	// To get specific record
	public Department getDepartment(int id) {

		Department dept = ht.get(Department.class, id);
		return dept;

	}

	// To get all records
	public List<Department> getAllDepartments() {

		List<Department> deptList = ht.loadAll(Department.class);
		return deptList;

	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

}
