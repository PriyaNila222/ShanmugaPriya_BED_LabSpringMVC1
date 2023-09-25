package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;

import com.greatlearning.EmployeeManagementSystem.entity.EmployeeDetails;

public interface EmployeeService {
	List<EmployeeDetails> getAllEmployees();

	EmployeeDetails saveEmployee(EmployeeDetails employeeDetails);

	EmployeeDetails getEmployeeById(long id);

	EmployeeDetails updateEmployee(long id, EmployeeDetails employeeDetails);

	void deleteEmployeeById(long id);
}
