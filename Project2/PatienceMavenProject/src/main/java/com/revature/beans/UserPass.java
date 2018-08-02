package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserPass {
	@Id
	@SequenceGenerator(sequenceName = "up_seq", name = "up_seq")
	@GeneratedValue(generator = "up_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String username;
	private String password;
	private String role;

	public UserPass() {
		super();
	}

	public UserPass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UserPass(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
