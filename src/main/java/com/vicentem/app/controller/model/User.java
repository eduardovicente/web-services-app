package com.vicentem.app.controller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull(message = "First Name cannot be null")
	@Size(min = 3,  message = "First Name must not be less than 3 caracters")
	private String firstName;
	
	@NotNull(message = "Last Name cannot be null")
	@Size(min = 3,  message = "Last Name must not be less than 3 caracters")
	private String lastName;
	
	@NotNull(message = "Email cannot be null")
	@Email
	private String email;
	
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 16, message = "Password must be equal or greater than 8 caracters and less than 16 caracters")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
