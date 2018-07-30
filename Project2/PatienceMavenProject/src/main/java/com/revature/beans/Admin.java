package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.beans.interfaces.Role;

@Entity
@Table(name = "Admin")
public class Admin implements Role {
	@Id
	@Column(name = "admin_id")
	@SequenceGenerator(sequenceName = "admin_seq", name = "admin_seq")
	@GeneratedValue(generator = "admin_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "admin_name")
	private String name;
	@Column(name = "admin_role")
	private String role;

	public Admin() {
		super();
	}

	public Admin(Integer id, String name, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
