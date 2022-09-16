package com.demo.constant;

public class ApplicationConstant {

	//end points 
	public static final String home = "/home";
	public static final String employee = "/employee";
	public static final String id = "/{id}";
	
	//start logs
	public static final String startHomeLog = "START - home()";
	public static final String startGetAllEmployeesLog = "START - getAllEmployees()";
	public static final String startGetEmployeeLog = "START - getEmployee()";
	public static final String startAddEmployeeLog = "START - addEmployee()";
	public static final String startUpdateEmployeeLog = "START - updateEmployee()";
	public static final String startDeleteEmployeeLog = "START - deleteEmployee()";
	
	//processing logs
	public static final String inHomeLog = "IN - home()";
	public static final String findingEmployees = "Finding Employees.....";
	public static final String findingEmployee = "Finding Employee.....";
	public static final String validating = "Validating Details.....";

	
	public static final String eFound = "Employees Found";
	public static final String found = "Employee Found";
	public static final String valid = "Valid Employee Details.....Adding it to Database";
	public static final String added = "Employee added to Database";
	public static final String delete = "Employee removed from Database";
	public static final String notFound = "Employee Not Found";
	
	public static final String employeeException = "Handling Employee Not Found.....";
	public static final String dataException = "Handling Invalid Data.....";
	public static final String handled = "Exception Handled Successfully.....";
	
	//end logs
	public static final String endHomeLog = "END - home()";
	public static final String endGetAllEmployeesLog = "END - getAllEmployees()";
	public static final String endGetEmployeeLog = "END - getEmployee()";
	public static final String endAddEmployeeLog = "END - addEmployee()";
	public static final String endUpdateEmployeeLog = "END - updateEmployee()";
	public static final String endDeleteEmployeeLog = "END - deleteEmployee()";
	
	//success messages
	public static final String welcome = "Welcome to the Employee Portal";
	public static final String deleted = "Employee Details Deleted Successfully";
	
	//error messages
	public static final String invalidID = "Employee Not Found with ID: ";
	public static final String emptyID = "ID should be of 3 digits";
	public static final String emptyName = "Name cannot be empty";
	public static final String emptyLocation = "Location cannot be empty";
}
