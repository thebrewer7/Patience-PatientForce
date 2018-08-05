package com.revature.beans;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.revature.beans.doctor.Doctor;
import com.revature.beans.history.History;
import com.revature.beans.nurse.Nurse;
import com.revature.enums.ConditionTypes;
/**
 * Represents a Patient Account and relationships to all associated accounts with users, nurses,
 * and doctors.
 * @author Austin
 *
 */
@Entity
public class Patient {
	@Id
	@SequenceGenerator(sequenceName = "patient_seq", name = "patient_seq")
	@GeneratedValue(generator = "patient_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	public List<UserAccount> users;
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	public List<Nurse> nurses;
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	public List<Doctor> doctors;

	@OneToOne(fetch=FetchType.EAGER)
	private History history;
	@OneToOne
	private UserPass userPass;

	private String name;
	private String location;
	private String status;
	private String condition;
	private Blob profilePicture;
	private String preferredDoctorName;
	private final String ROLE = "patient";

	/**
	 * No-Args Constructor
	 */
	public Patient() {
		super();
	}

	/**
	 * Used to instantiate a Patient with no associated users, doctors, or nuses
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

	/**
	 * Used to instantiate a Patient with no associated users, doctors, or nuses
	 * 
	 * @param userPass
	 * @param name
	 * @param location
	 * @param status
	 * @param condition
	 */
	public Patient(UserPass userPass, String name, String location, String status, ConditionTypes condition, History history) {
		super();
		this.userPass = userPass;
		this.name = name;
		this.location = location;
		this.status = status;
		this.condition = condition.toString();
		this.history = history;
	}
	
	/**
	 * Instantiate a patient with no associated nurses, doctors, or users. Also lacks profile picture and
	 * current condition.
	 * @param name
	 * @param id
	 * @param location
	 * @param status
	 */
	public Patient(String name, Integer id, String location, String status) {
		super();
		this.name = name;
		this.id = id;
		this.location = location;
		this.status = status;
	}
	
	/**
	 * Instantiate a patient with no associated nurses, doctors, or users. Also lacks profile picture and
	 * current condition.
	 * @param name
	 * @param id
	 * @param location
	 * @param history
	 * @param status
	 */
	public Patient(String name, Integer id, String location, String status, History history) {
		super();
		this.name = name;
		this.id = id;
		this.location = location;
		this.status = status;
		this.history = history;
	}

	/**
	 * Full instantiation without a profile picture
	 * @param id
	 * @param nurses
	 * @param doctors
	 * @param history
	 * @param userPass
	 * @param name
	 * @param location
	 * @param status
	 * @param condition
	 * @param preferredDoctorName
	 */
	public Patient(Integer id, List<Nurse> nurses, List<Doctor> doctors, History history, UserPass userPass,
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

	/**
	 * 
	 * @param users
	 * @param nurses
	 * @param doctors
	 * @param history
	 * @param userPass
	 * @param name
	 * @param location
	 * @param status
	 * @param condition
	 * @param preferredDoctorName
	 */
	public Patient(List<UserAccount> users, List<Nurse> nurses, List<Doctor> doctors, History history,
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

	/**
	 * 
	 * @param users
	 * @param nurses
	 * @param doctors
	 * @param history
	 * @param userPass
	 * @param name
	 * @param location
	 * @param status
	 * @param condition
	 * @param profilePicture
	 * @param preferredDoctorName
	 */
	public Patient(List<UserAccount> users, List<Nurse> nurses, List<Doctor> doctors, History history,
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

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", history=" + history + ", userPass=" + userPass + ", name=" + name
				+ ", location=" + location + ", status=" + status + ", condition=" + condition + "]";
	}



}
