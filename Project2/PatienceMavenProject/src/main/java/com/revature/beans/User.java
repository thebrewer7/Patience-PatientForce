package com.revature.beans;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	@Id
	@SequenceGenerator(sequenceName = "review_seq", name = "review_seq")
	@GeneratedValue(generator = "review_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToMany(mappedBy="User")
	@JoinTable
	private List<Patient> patients;

	private String name;
	private String role;
	private Blob profilePicture;
	private Date lastLogin;
	
	public User() {
		super();
	}

	public User(String name, Date lastLogin) {
		this.name = name;
		this.role = "user";
		this.lastLogin = lastLogin;
	}

	public User(Integer id, String name, String role, Date lastLogin, List<Patient> patients) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.lastLogin = lastLogin;
		this.patients = patients;
	}

	public User(Integer id, String name, String role, Date lastLogin, List<Patient> patients, Blob profilePicture) {
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

	public Blob getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Blob profilePicture) {
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
