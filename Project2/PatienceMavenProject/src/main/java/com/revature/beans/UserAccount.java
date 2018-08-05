package com.revature.beans;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * Represents a user and the relationships with all associated patients.
 * @author Austin
 *
 */

@Entity
public class UserAccount {
	@Id
	@SequenceGenerator(sequenceName = "review_seq", name = "review_seq")
	@GeneratedValue(generator = "review_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable
	public List<Patient> patients;

	@OneToOne
	private UserPass userPass;

	private String name;
	private final String ROLE = "user";
	private Blob profilePicture;
	private Date lastLogin;

	/**
	 * No-Args Constructor.
	 */
	public UserAccount() {
		super();
	}

	/**
	 * Used to create a user that has no associated patients
	 * @param userPass
	 * @param name
	 * @param lastLogin
	 */
	public UserAccount(UserPass userPass, String name, Date lastLogin) {
		super();
		this.userPass = userPass;
		this.name = name;
		this.lastLogin = lastLogin;
	}

	/**
	 * used for full instantiated. Recommended for updates
	 * @param patients
	 * @param userPass
	 * @param name
	 * @param profilePicture
	 * @param lastLogin
	 */
	public UserAccount(List<Patient> patients, UserPass userPass, String name, Blob profilePicture, Date lastLogin) {
		super();
		this.patients = patients;
		this.userPass = userPass;
		this.name = name;
		this.profilePicture = profilePicture;
		this.lastLogin = lastLogin;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return ROLE;
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

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", patients=" + patients + ", name=" + name + ", lastLogin=" + lastLogin + "]";
	}

}
