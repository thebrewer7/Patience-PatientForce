package com.revature.beans;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.revature.enums.Roles;

@Entity
public class UserPass {
	@Id
	@SequenceGenerator(sequenceName = "up_seq", name = "up_seq")
	@GeneratedValue(generator = "up_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private Integer roleId;
	
	private String username;
	private String password;
	private String type;
	
	
	public UserPass(String username, String password, Roles type, Integer roleId) {
		super();
		this.username = username;
		this.password = password;
		this.type = type.toString();
		this.roleId = roleId;
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

	public String getType() {
		return type;
	}

	public void setType(Role type) {
		this.type = type.toString();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}
	
	
}
