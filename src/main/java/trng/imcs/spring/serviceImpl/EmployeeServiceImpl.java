package trng.imcs.spring.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import trng.imcs.spring.model.Employee;
import trng.imcs.spring.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EmployeeService employeeService;

	private static String URL = "http://localhost:8080/RestController/employees";

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployeesByDeptId(int deptId) {
		return (List<Employee>) restTemplate.getForObject(URL + "/dept/" + deptId, List.class);

	}

	public int addEmployee(Employee emp) {
		ResponseEntity<Integer> res = restTemplate.postForEntity(URL + "/", emp, Integer.class);
		return res.getBody();

	}

	public Employee updateEmployee(Employee emp) {
		HttpEntity<Employee> request = new HttpEntity<>(emp);
		ResponseEntity<Employee> res = restTemplate.exchange(URL, HttpMethod.PUT, request, Employee.class);
		return res.getBody();
	}

	public void deleteEmployee(int empId) {
		String entityUrl = URL + "/" + empId;
		restTemplate.delete(entityUrl);

	}

	public Employee getEmployee(int empId) {
		String entityUrl = URL + "/" + empId;
		ResponseEntity<Employee> response = restTemplate.getForEntity(entityUrl, Employee.class);
		if (response.getStatusCodeValue() == 200) {
			return null;
		}
		return response.getBody();
	}

}
