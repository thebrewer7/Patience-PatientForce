package com.revature.beans;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.revature.beans.interfaces.Role;

@Entity
public class Admin implements Role {
	@Id
	@SequenceGenerator(sequenceName = "admin_seq", name = "admin_seq")
	@GeneratedValue(generator = "admin_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String name;
	private Blob profilePicture;
	private final String ROLE = "admin";

	public Admin() {
		super();
	}

	public Admin(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public Blob getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Blob profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return ROLE;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", role=" + ROLE + "]";
	}

}
