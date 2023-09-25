package com.greatlearning.EmployeeManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employeedetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@NotEmpty(message = "Field cannot be empty")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty(message = "Field cannot be empty")
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "Field cannot be empty")
	@Email
	@Column(name = "email_id")
	private String emailId;

}
