package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {

	public String home();

	public List<Employee> getAllEmployees();

	public Employee getEmployee(String id);

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public String deleteEmployee(String id);
	
	
}
