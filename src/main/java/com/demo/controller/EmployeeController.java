package com.demo.controller;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.constant.ApplicationConstant;
import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@RestController
public class EmployeeController{
	
	private static final Logger log = Logger.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(ApplicationConstant.home)
	public String home() {
		
		MDC.put("correlationID", UUID.randomUUID());
		log.info(ApplicationConstant.startHomeLog);
		
		String welcome = employeeService.home();
		
		log.info(ApplicationConstant.endHomeLog);
		MDC.clear();
		
		return welcome;
	}
	
	@GetMapping(ApplicationConstant.employee)
	public List<Employee> getAllEmployees() {
		
		MDC.put("correlationID", UUID.randomUUID());
		log.info(ApplicationConstant.startGetAllEmployeesLog);
		
		List<Employee> employees = employeeService.getAllEmployees(); 
		
		log.info(ApplicationConstant.endGetAllEmployeesLog);
		MDC.clear();
		
		return employees;
	}
	
	@GetMapping(ApplicationConstant.employee + ApplicationConstant.id)
	public Employee getEmployee(@PathVariable String id) {
		
		MDC.put("correlationID", UUID.randomUUID());
		log.info(ApplicationConstant.startGetEmployeeLog);
		
		Employee  employee = employeeService.getEmployee(id); 
		
		log.info(ApplicationConstant.endGetEmployeeLog);
		MDC.clear();
		
		return employee;
	}
	
	@PostMapping(ApplicationConstant.employee)
	public Employee addEmployee(@RequestBody Employee employee) {
		
		MDC.put("correlationID", UUID.randomUUID());
		log.info(ApplicationConstant.startAddEmployeeLog);
		
		Employee newEmployee = employeeService.addEmployee(employee); 
		
		log.info(ApplicationConstant.endAddEmployeeLog);
		MDC.clear();
		
		return newEmployee; 
	}
	
	@PutMapping(ApplicationConstant.employee)
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		MDC.put("correlationID", UUID.randomUUID());
		log.info(ApplicationConstant.startUpdateEmployeeLog);
		
		Employee updatedEmployee = employeeService.updateEmployee(employee); 
		
		log.info(ApplicationConstant.endUpdateEmployeeLog);
		MDC.clear();
		
		return updatedEmployee; 
	}
	
	@DeleteMapping(ApplicationConstant.employee + ApplicationConstant.id)
	public String deleteEmployee(@PathVariable String id) {
		
		MDC.put("correlationID", UUID.randomUUID());
		log.info(ApplicationConstant.startDeleteEmployeeLog);
		
		String response = employeeService.deleteEmployee(id);
		
		log.info(ApplicationConstant.endDeleteEmployeeLog);
		MDC.clear();
		
		return response; 
	}
}
