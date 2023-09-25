package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementSystem.entity.EmployeeDetails;
import com.greatlearning.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeDetails saveEmployee(EmployeeDetails employeeDetails) {
		return employeeRepository.save(employeeDetails);
	}

	@Override
	public EmployeeDetails getEmployeeById(long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public EmployeeDetails updateEmployee(long id, EmployeeDetails employeeDetails) {
		EmployeeDetails existingEmployee = getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employeeDetails.getFirstName());
		existingEmployee.setLastName(employeeDetails.getLastName());
		existingEmployee.setEmailId(employeeDetails.getEmailId());
		return saveEmployee(employeeDetails);
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
	}

}
