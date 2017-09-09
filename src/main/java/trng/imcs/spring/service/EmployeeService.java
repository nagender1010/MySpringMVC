package trng.imcs.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import trng.imcs.spring.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployeesByDeptId(int deptId);

	public int addEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public void deleteEmployee(int empId);

	public Employee getEmployee(int empId);

}
