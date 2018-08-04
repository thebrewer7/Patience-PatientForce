package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Represents a username and password combo as well as an associated role string for easy database lookup.
 * @author Austin
 *
 */
@Entity
public class UserPass {
	@Id
	@SequenceGenerator(sequenceName = "up_seq", name = "up_seq")
	@GeneratedValue(generator = "up_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String username;
	@JsonIgnore
	private String password;
	private String role;

	/**
	 * No-Args Constructor
	 */
	public UserPass() {
		super();
	}

	/**
	 * Makes a new UserPass combo that only contains username and password
	 * @param username
	 * @param password
	 */
	public UserPass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		role = "user";
	}
	
	/**
	 * Full instantiation with associated acount string for easy database access.
	 * @param username
	 * @param password
	 * @param role
	 */
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
