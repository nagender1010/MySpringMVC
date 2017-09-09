package trng.imcs.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import trng.imcs.spring.model.Department;
import trng.imcs.spring.model.Employee;
import trng.imcs.spring.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	final static Logger logger = Logger.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		logger.debug("initBinder method called");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		logger.debug("defaultPage method called");
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;

	}

	@RequestMapping(value = "/empForm", method = RequestMethod.GET)
	public ModelAndView getEmpForm() {
		logger.debug("defaultPage method called");
		ModelAndView modelAndView = new ModelAndView("employee");
		return modelAndView;

	}

	@RequestMapping(value = "/eSearch", method = RequestMethod.GET)
	public ModelAndView getEmployee(@RequestParam("eSearch") int empId, @RequestParam("operations") String operations) {
		logger.debug("defaultPage method called");
		System.out.println("---------------------------checking operations---------------");
		System.out.println(operations);
		ModelAndView modelAndView = new ModelAndView("employee");
		if (operations != null && operations.equals("updateOperFrmDept")) {
			modelAndView.addObject("pageType", "updateOperFrmDept");
			modelAndView.addObject("hiddenValForDelete", "empFormDeptDelete");
			modelAndView.addObject("status", true);
		}
		Employee emp = employeeService.getEmployee(empId);
		System.out.println(emp);
		if (emp == null) {
			modelAndView.addObject("msg", "Employee Info doesnt exists with the given ID");
			return modelAndView;
		}
		modelAndView.addObject("eInfo", emp);
		modelAndView.addObject("status", true);
		return modelAndView;

	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("updateForm") Employee employee, @ModelAttribute("updateForm") Employee employee1, @RequestParam("hiddenValForDept") String oper) {
		logger.debug("defaultPage method called");
		System.out.println("entered into updateemployee method " + employee);
		Employee emp = employeeService.updateEmployee(employee);
		if(oper!=null&&oper.equals("empFormToDept")) {
			Employee emp1 = employeeService.updateEmployee(employee1);
			ModelAndView modelAndView0 = new ModelAndView("department");
			List<Employee> list = employeeService.getAllEmployeesByDeptId(employee1.getDeptId());
			modelAndView0.addObject("empList", list);
			modelAndView0.addObject("oper", oper);
			modelAndView0.addObject("status", true);
			return modelAndView0;
		}
		ModelAndView modelAndView = new ModelAndView("employee");
		modelAndView.addObject("msg", "User ID " + employee.getId() + " updated successfully");
		modelAndView.addObject("eInfo", emp);
		modelAndView.addObject("status", true);
		return modelAndView;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletEmployee(@RequestParam("deleteId") int deleteId, @RequestParam("hiddenValForDelete") String oper, @RequestParam("deptId") int deptId) {
		logger.debug("defaultPage method called");
		System.out.println("-------------------------------------------");
		System.out.println("oper "+ oper+" deptId: " + deptId);
		if(oper!=null&&oper.equals("empFormDeptDelete")) {
			employeeService.deleteEmployee(deleteId);
			ModelAndView modelAndView0 = new ModelAndView("department");
			List<Employee> list = employeeService.getAllEmployeesByDeptId(deptId);
			modelAndView0.addObject("empList", list);
			modelAndView0.addObject("oper", oper);
			modelAndView0.addObject("status", true);
			return modelAndView0;
		}
		ModelAndView modelAndView = new ModelAndView("employee");
		employeeService.deleteEmployee(deleteId);
		modelAndView.addObject("msg", "Employee Deleted Successfully");
		modelAndView.addObject("status", true);
		return modelAndView;

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("addForm") Employee employee) {
		employee.setId(0);
		logger.debug("defaultPage method called");
		System.out.println("entered into addEmployee method " + employee);
		int empId = employeeService.addEmployee(employee);
		
		ModelAndView modelAndView = new ModelAndView("employee");
		modelAndView.addObject("msg", "User ID " + empId + " added successfully");
		employee.setId(empId);
		modelAndView.addObject("eInfo", employee);
		modelAndView.addObject("status", false);
		return modelAndView;

	}

	@RequestMapping(value = "/viewAllEmployees", method = RequestMethod.GET)
	public ModelAndView getAllEmployees(@RequestParam("departId") int deptId) {
		logger.debug("defaultPage method called");
		ModelAndView modelAndView = new ModelAndView("department");
		List<Employee> list = employeeService.getAllEmployeesByDeptId(deptId);
		System.out.println(list);
		if (list.size() == 0) {
			modelAndView.addObject("msg", "No Employees in that Dept");
			return modelAndView;
		}
		modelAndView.addObject("empList", list);
		return modelAndView;

	}

}
