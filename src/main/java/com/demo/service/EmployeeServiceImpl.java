package com.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.constant.ApplicationConstant;
import com.demo.controller.EmployeeController;
import com.demo.dao.EmployeeDAO;
import com.demo.entity.Employee;
import com.demo.exception.EmployeeNotFoundException;
import com.demo.exception.InvalidDataException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = Logger.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public String home() {
		log.info(ApplicationConstant.inHomeLog);

		return ApplicationConstant.welcome;
	}

	@Override
	public List<Employee> getAllEmployees() {
		log.info(ApplicationConstant.findingEmployees);

		List<Employee> employees = employeeDAO.findAll();

		log.info(ApplicationConstant.eFound);

		return employees;
	}

	@Override
	public Employee getEmployee(String id) {
		log.info(ApplicationConstant.findingEmployee);

		try {
			Employee employee = employeeDAO.findById(id).get();

			log.info(ApplicationConstant.found);

			return employee;
		} catch (NoSuchElementException e) {

			log.error(ApplicationConstant.notFound);

			throw new EmployeeNotFoundException(ApplicationConstant.invalidID + id);
		}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		log.info(ApplicationConstant.validating);

		if (checkID(employee.getId())) {
			if (checkName(employee.getName())) {
				if (checkLocation(employee.getLocation())) {

					log.info(ApplicationConstant.valid);

					employeeDAO.save(employee);

					log.info(ApplicationConstant.added);

					return employee;
				}
				log.error(ApplicationConstant.emptyLocation);

				throw new InvalidDataException(ApplicationConstant.emptyLocation);
			}
			log.error(ApplicationConstant.emptyName);

			throw new InvalidDataException(ApplicationConstant.emptyName);
		}
		log.error(ApplicationConstant.emptyID);

		throw new InvalidDataException(ApplicationConstant.emptyID);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		log.info(ApplicationConstant.findingEmployee);

		if (checkID(employee.getId())) {
			try {
				Employee updatedEmployee = employeeDAO.findById(employee.getId()).get();

				log.info(ApplicationConstant.found);

				if (checkName(employee.getName())) {
					if (checkLocation(employee.getLocation())) {

						log.info(ApplicationConstant.valid);

						updatedEmployee.setName(employee.getName());
						updatedEmployee.setLocation(employee.getLocation());
						employeeDAO.save(updatedEmployee);

						log.info(ApplicationConstant.added);

						return updatedEmployee;
					}
					log.error(ApplicationConstant.emptyLocation);

					throw new InvalidDataException(ApplicationConstant.emptyLocation);
				}
				log.error(ApplicationConstant.emptyName);

				throw new InvalidDataException(ApplicationConstant.emptyName);
			} catch (NoSuchElementException e) {

				log.error(ApplicationConstant.notFound);

				throw new EmployeeNotFoundException(ApplicationConstant.invalidID + employee.getId());
			}
		}
		log.error(ApplicationConstant.emptyID);

		throw new InvalidDataException(ApplicationConstant.emptyID);
	}

	@Override
	public String deleteEmployee(String id) {
		log.info(ApplicationConstant.findingEmployee);

		try {
			employeeDAO.deleteById(id);
			
			log.info(ApplicationConstant.found);

			log.info(ApplicationConstant.delete);

			return ApplicationConstant.deleted;
		} catch (Exception e) {

			log.error(ApplicationConstant.notFound);

			throw new EmployeeNotFoundException(ApplicationConstant.invalidID + id);
		}
	}

	private boolean checkID(String id) {
		if (id.equals("") || Integer.parseInt(id) < 100 || Integer.parseInt(id) > 999) {
			return false;
		}
		return true;
	}

	private boolean checkName(String name) {
		if (name.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkLocation(String location) {
		if (location.equals("")) {
			return false;
		}
		return true;
	}

}
