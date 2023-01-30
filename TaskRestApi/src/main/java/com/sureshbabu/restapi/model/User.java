package com.sureshbabu.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tbl_user")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	@Column(name = "first_name")
	@ApiModelProperty(example = "firstname", required = true)	
	private String firstName;
	

	@Column(name = "last_name")
	@ApiModelProperty(example = "lastname", required = true)
	private String lastName;
	

	@Column(name = "email_address")
	@ApiModelProperty(example = "abc@x.com", required = true)
	private String emailId;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}
	
	
}
