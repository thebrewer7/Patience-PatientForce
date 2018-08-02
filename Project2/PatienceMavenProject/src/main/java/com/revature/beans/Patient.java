package com.revature.beans;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	public List<UserAccount> users;
	@ManyToMany
	public List<Nurse> nurses;
	@ManyToMany
	public List<Doctor> doctors;

	@OneToMany
	private List<History> history;
	@OneToOne
	private UserPass userPass;

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

	/**
	 * Used to instantiate a Patient with no associate users, doctors, or nuses
	 * 
	 * @param userPass
	 * @param name
	 * @param location
	 * @param status
	 * @param condition
	 */
	public Patient(UserPass userPass, String name, String location, String status, ConditionTypes condition) {
		super();
		this.userPass = userPass;
		this.name = name;
		this.location = location;
		this.status = status;
		this.condition = condition.toString();
	}

	public Patient(String name, Integer id, String location, String status) {
		super();
		this.name = name;
		this.id = id;
		this.location = location;
		this.status = status;
	}

	public Patient(Integer id, List<Nurse> nurses, List<Doctor> doctors, List<History> history, UserPass userPass,
			String name, String location, String status, String condition, String preferredDoctorName) {
		super();
		this.id = id;
		this.nurses = nurses;
		this.doctors = doctors;
		this.history = history;
		this.userPass = userPass;
		this.name = name;
		this.location = location;
		this.status = status;
		this.condition = condition;
		this.preferredDoctorName = preferredDoctorName;
	}

	public Patient(List<UserAccount> users, List<Nurse> nurses, List<Doctor> doctors, List<History> history,
			UserPass userPass, String name, String location, String status, String condition,
			String preferredDoctorName) {
		super();
		this.users = users;
		this.nurses = nurses;
		this.doctors = doctors;
		this.history = history;
		this.userPass = userPass;
		this.name = name;
		this.location = location;
		this.status = status;
		this.condition = condition;
		this.preferredDoctorName = preferredDoctorName;
	}

	public Patient(List<UserAccount> users, List<Nurse> nurses, List<Doctor> doctors, List<History> history,
			UserPass userPass, String name, String location, String status, String condition, Blob profilePicture,
			String preferredDoctorName) {
		super();
		this.users = users;
		this.nurses = nurses;
		this.doctors = doctors;
		this.history = history;
		this.userPass = userPass;
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

	public UserPass getUserPass() {
		return userPass;
	}

	public void setUserPass(UserPass userPass) {
		this.userPass = userPass;
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
