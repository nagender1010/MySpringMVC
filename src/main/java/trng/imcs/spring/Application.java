package trng.imcs.spring;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import trng.imcs.spring.model.Employee;
import trng.imcs.spring.service.EmployeeService;
import trng.imcs.spring.service.DepartmentService;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class Application extends SpringBootServletInitializer{
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);	
	}

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(Application.class, args);
		ApplicationContext context =SpringApplication.run(Application.class, args);
		java.util.Date d = new java.util.Date(); 
		Date sqlDate = new Date(d.getTime());
		
		//Employee employee = new Employee(1, "nag", "nag1", "123", 24, sqlDate,
//				 sqlDate, 1, 1234, 1);
		
		//Test
		EmployeeService ser = (EmployeeService) context.getBean("employeeService");
		System.out.println("---------------------------------------------------------------------1");
		long startTime=System.currentTimeMillis();
		System.out.println(ser.getEmployee(1));
		long endTime=System.currentTimeMillis();
		System.out.println("Time Difference "+ (endTime-startTime));
		
		System.out.println("---------------------------------------------------------------------2");
		long startTime1=System.currentTimeMillis();
		System.out.println(ser.getEmployee(1));
		long endTime1=System.currentTimeMillis();
		System.out.println("Time Difference "+ (endTime1-startTime1));
		
		
		
		System.out.println("---------------------------------------------------------------------3");
		long startTime2=System.currentTimeMillis();
		System.out.println(ser.getEmployee(1));
		long endTime2=System.currentTimeMillis();
		System.out.println("Time Difference "+ (endTime2-startTime2));
		
		

		System.out.println("---------------------------------------------------------------------4");
		long startTime3=System.currentTimeMillis();
		System.out.println(ser.getEmployee(1));
		long endTime3=System.currentTimeMillis();
		System.out.println("Time Difference "+ (endTime3-startTime3));
		
		
	}
    
    


}
