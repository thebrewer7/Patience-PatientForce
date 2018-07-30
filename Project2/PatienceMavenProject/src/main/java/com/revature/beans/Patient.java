package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.revature.beans.doctor.Doctor;
import com.revature.beans.interfaces.Role;
import com.revature.beans.nurse.Nurse;
import com.revature.enums.ConditionTypes;

@Entity
public class Patient implements Role {
	@Id
	@SequenceGenerator(sequenceName = "patient_seq", name = "patient_seq")
	@GeneratedValue(generator = "patient_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToMany(mappedBy="Patient")
	@JoinTable
	private List<User> users;
	@ManyToMany(mappedBy="Patient")
	@JoinTable
	private List<Nurse> nurses;
	@ManyToMany(mappedBy="Patient")
	@JoinTable
	private List<Doctor> doctors;

	@OneToMany(mappedBy="Patient")
	@JoinColumn(name = "history_id")
	private List<History> history;

	private String name;
	private String role;
	private String location;
	private String status;
	private String condition;
	private String preferredDoctorName;

	public Patient() {
		super();
	}

	public Patient(String name, String location, String status, String preferredDoctorName, ConditionTypes condition,
			List<Nurse> nurses, List<Doctor> doctors, List<User> users, List<History> history) {
		super();
		this.name = name;
		this.role = "patient";
		this.location = location;
		this.status = status;
		this.condition = condition.toString();
		this.preferredDoctorName = preferredDoctorName;
		this.nurses = nurses;
		this.doctors = doctors;
		this.users = users;
		this.history = history;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getPreferredDoctorName() {
		return preferredDoctorName;
	}

	public void setPreferredDoctorName(String preferredDoctorName) {
		this.preferredDoctorName = preferredDoctorName;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", role=" + role + ", location=" + location + ", status="
				+ status + ", preferredDoctorName=" + preferredDoctorName + ", nurses=" + nurses + ", doctors="
				+ doctors + ", users=" + users + ", history=" + history + "]";
	}

}
