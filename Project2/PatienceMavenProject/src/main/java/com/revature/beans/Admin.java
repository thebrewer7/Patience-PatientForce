package com.revature.beans;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * This is an Admin Account that oversees all application ongoins.
 * @author Austin
 *
 */
@Entity
public class Admin {
	@Id
	@SequenceGenerator(sequenceName = "admin_seq", name = "admin_seq")
	@GeneratedValue(generator = "admin_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToOne
	private UserPass userPass;

	private String name;
	private Blob profilePicture;
	private final String ROLE = "admin";

	/**
	 * No-Args Constructor
	 */
	public Admin() {
		super();
	}

	/**
	 * Just makes an admin with a name and userpass combo
	 * @param name
	 * @param userPass
	 */
	public Admin(String name, UserPass userPass) {
		this.name = name;
		this.userPass = userPass;
	}

	public Integer getId() {
		return id;
	}

	public UserPass getUserPass() {
		return userPass;
	}

	public void setUserPass(UserPass userPass) {
		this.userPass = userPass;
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
