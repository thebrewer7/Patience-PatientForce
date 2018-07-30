package com.revature.beans;

import java.sql.Date;
import java.util.List;

import com.revature.beans.interfaces.Role;

public class User implements Role {
	private Integer id;
	private String name;
	private String role;
	private Byte[] profilePicture;
	private Date lastLogin;
	private List<Patient> patients;

	public User() {
		super();
	}
	
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User(Integer id, String name, String role, Date lastLogin) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.lastLogin = lastLogin;
	}

	public User(Integer id, String name, String role, Date lastLogin, List<Patient> patients) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.lastLogin = lastLogin;
		this.patients = patients;
	}

	public User(Integer id, String name, String role, Date lastLogin, List<Patient> patients, Byte[] profilePicture) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.profilePicture = profilePicture;
		this.lastLogin = lastLogin;
		this.patients = patients;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
