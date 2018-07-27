package com.patience.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Column(name="user_id") 
	@SequenceGenerator(sequenceName="user_seq", name="user_seq")
	@GeneratedValue(generator="user_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="user_name")
	private String name;
	@Column(name="user_role")
	private String role;
	@Column(name="user_image")
	private byte[] profilePicture;
	@Column(name="user_logintime")
	private Date lastLogin;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_2_patient", joinColumns=@JoinColumn(name="patient_id"),
				inverseJoinColumns=@JoinColumn(name="nurse_id"))	
	private Patient patients;
	
	public User() {
		super();
	}

	public User(String name, String role, byte[] profilePicture, Date lastLogin) {
		super();
		this.name = name;
		this.role = role;
		this.profilePicture = profilePicture;
		this.lastLogin = lastLogin;
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

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
