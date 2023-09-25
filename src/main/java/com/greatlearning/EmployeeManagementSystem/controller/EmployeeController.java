package com.greatlearning.EmployeeManagementSystem.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.EmployeeManagementSystem.entity.EmployeeDetails;
import com.greatlearning.EmployeeManagementSystem.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;

	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		EmployeeDetails employeeDetails = new EmployeeDetails();
		model.addAttribute("employee", employeeDetails);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDetails employeeDetails,
			BindingResult result) {
		if (result.hasErrors()) {
			return "create_employee";
		}
		employeeService.saveEmployee(employeeDetails);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable long id,
			@Valid @ModelAttribute("employee") EmployeeDetails employeeDetails, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "edit_employee";
		}
		employeeService.updateEmployee(id, employeeDetails);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

}
