package com.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDAO;
import com.demo.entity.Employee;
import com.demo.exception.EmployeeNotFoundException;
import com.demo.exception.InvalidDataException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public String home() {
		return "Welcome to the Employee Portal";
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee getEmployee(String id) {
		try {
			return employeeDAO.findById(id).get();
		}catch(Exception e) {
			throw new EmployeeNotFoundException("Employee Not Found with ID: " + id);
		}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		if(checkID(employee.getId())) {
			if(checkName(employee.getName())) {
				if(checkLocation(employee.getLocation())){
					return employeeDAO.save(employee);
				}
				throw new InvalidDataException("Location cannot be empty");
			}
			throw new InvalidDataException("Name cannot be empty");
		}
		throw new InvalidDataException("ID should be of 3 digits");
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		if(checkID(employee.getId())) {
			try {
				Employee updatedEmployee = employeeDAO.findById(employee.getId()).get();
				if(checkName(employee.getName())) {
					if(checkLocation(employee.getLocation())){
						updatedEmployee.setName(employee.getName());
						updatedEmployee.setLocation(employee.getLocation());
						return updatedEmployee;
					}
					throw new InvalidDataException("Location cannot be empty");
				}
				throw new InvalidDataException("Name cannot be empty");
			}catch(NoSuchElementException e) {
				throw new EmployeeNotFoundException("Employee Not Found with ID: " + employee.getId());
			}
		}
		throw new InvalidDataException("ID should be of 3 digits");
	}

	@Override
	public String deleteEmployee(String id) {
		try {
			employeeDAO.deleteById(id);
			return "Employee Details Deleted Successfully";
		}catch(Exception e) {
			throw new EmployeeNotFoundException("Employee Not Found with ID: " + id);
		}
	}
	
	private boolean checkID(String id) {
		if(id.equals("") ||	Integer.parseInt(id) < 100 || Integer.parseInt(id) > 999) {
			return false;
		}
		return true;
	}
	

	private boolean checkName(String name) {
		if(name.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkLocation(String location) {
		if(location.equals("")) {
			return false;
		}
		return true;
	}

}
