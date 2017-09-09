package trng.imcs.spring.service;

import java.util.List;

import trng.imcs.spring.model.Department;

public interface DepartmentService {
	
	public Department getDepartment(int deptId);

	public List<Department> getAllDepartments();


}
