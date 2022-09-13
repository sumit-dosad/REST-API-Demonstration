package com.demo.controller;

import java.util.List;

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


//demo for github
@RestController
public class EmployeeController{
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(ApplicationConstant.home)
	public String home() {
		return employeeService.home();
	}
	
	@GetMapping(ApplicationConstant.employee)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(ApplicationConstant.employee + ApplicationConstant.id)
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}
	
	@PostMapping(ApplicationConstant.employee)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping(ApplicationConstant.employee)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping(ApplicationConstant.employee + ApplicationConstant.id)
	public String deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(id);
	}
}
