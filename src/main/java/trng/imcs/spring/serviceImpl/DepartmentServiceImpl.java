package trng.imcs.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import trng.imcs.spring.model.Department;
import trng.imcs.spring.model.Employee;
import trng.imcs.spring.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	private static String URL = "http://localhost:8080/RestController/department/";
	
	@Autowired
	DepartmentService departmentService;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Department getDepartment(int deptId) {
		String entityUrl = URL + deptId;
		ResponseEntity<Department> response = restTemplate.getForEntity(entityUrl, Department.class);
		if (response.getStatusCodeValue() == 200) {
			return null;
		}
		return response.getBody();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartments() {
		return (List<Department>) restTemplate.getForObject(URL, Department.class);
	}

}
