package trng.imcs.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import trng.imcs.spring.model.Department;
import trng.imcs.spring.model.Employee;
import trng.imcs.spring.service.DepartmentService;
import trng.imcs.spring.service.EmployeeService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	final static Logger logger = Logger.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/deptForm", method = RequestMethod.GET)
	public ModelAndView getDeptForm() {
		logger.debug("defaultPage method called");
		ModelAndView modelAndView = new ModelAndView("department");
		return modelAndView;

	}

	
	@RequestMapping(value = "/deptSearch", method = RequestMethod.GET)
	public ModelAndView getEmployee(@RequestParam("dSearch") int deptId) {
		logger.debug("defaultPage method called");
		ModelAndView modelAndView = new ModelAndView("department");
		Department dept = departmentService.getDepartment(deptId);
		System.out.println(dept);
		if (dept == null) {
			modelAndView.addObject("msg", "Department Info doesnt exists with the given ID");
			return modelAndView;
		}
		modelAndView.addObject("deptInfo", dept);
		return modelAndView;

	}
	
}
