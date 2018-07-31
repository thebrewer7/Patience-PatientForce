package com.revature.beans;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.revature.beans.doctor.Doctor;
import com.revature.beans.history.History;
import com.revature.beans.nurse.Nurse;
import com.revature.enums.ConditionTypes;

@Entity
public class Patient {
	@Id
	@SequenceGenerator(sequenceName = "patient_seq", name = "patient_seq")
	@GeneratedValue(generator = "patient_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@ManyToMany
	private List<UserAccount> users;
	@ManyToMany
	private List<Nurse> nurses;
	@ManyToMany
	private List<Doctor> doctors;

	@OneToMany
	private List<History> history;

	private String name;
	private String location;
	private String status;
	private String condition;
	private Blob profilePicture;
	private String preferredDoctorName;
	private final String ROLE = "patient";

	public Patient() {
		super();
	}

	public Patient(String name, String location, String status, String preferredDoctorName, ConditionTypes condition,
			List<Nurse> nurses, List<Doctor> doctors, List<UserAccount> users, List<History> history) {
		super();
		this.name = name;
		this.location = location;
		this.status = status;
		this.condition = condition.toString();
		this.preferredDoctorName = preferredDoctorName;
		this.nurses = nurses;
		this.doctors = doctors;
		this.users = users;
		this.history = history;
	}

	public Patient(List<UserAccount> users, List<Nurse> nurses, List<Doctor> doctors, List<History> history, String name,
			String location, String status, String condition, Blob profilePicture, String preferredDoctorName) {
		super();
		this.users = users;
		this.nurses = nurses;
		this.doctors = doctors;
		this.history = history;
		this.name = name;
		this.location = location;
		this.status = status;
		this.condition = condition;
		this.profilePicture = profilePicture;
		this.preferredDoctorName = preferredDoctorName;
	}

	public Integer getId() {
		return id;
	}

	public String getCondition() {
		return condition;
	}

	public Blob getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Blob profilePicture) {
		this.profilePicture = profilePicture;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

	public List<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(List<UserAccount> users) {
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
		return "Patient [id=" + id + ", name=" + name + ", role=" + ROLE + ", location=" + location + ", status="
				+ status + ", preferredDoctorName=" + preferredDoctorName + ", nurses=" + nurses + ", doctors="
				+ doctors + ", users=" + users + ", history=" + history + "]";
	}

}
