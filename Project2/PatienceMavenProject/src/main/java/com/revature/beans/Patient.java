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
import javax.persistence.Table;

import com.revature.beans.interfaces.Role;

@Entity
@Table(name = "Patient")
public class Patient implements Role{
	@Id
	@Column(name = "patient_id")
	@SequenceGenerator(sequenceName = "patient_seq", name = "patient_seq")
	@GeneratedValue(generator = "patient_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "patient_name")
	private String name;
	@Column(name = "patient_role")
	private String role;
	@Column(name = "patient_location")
	private String location;
	@Column(name = "patient_status")
	private String status;
	@Column(name = "patient_condition")
	private String condition;
	public static String[] conditionTypes = 
		{"Undetermined", "Good", "Fair", "Serious", "Critical", "Deceased"};
	@Column(name = "patient_prefferedDoctor")
	private String preferredDoctorName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_2_patient", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "patient_2_nurse", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "nurse_id"))
	private List<Nurse> nurses;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "patient_2_doctor", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id"))
	private List<Doctor> doctors;

	@OneToMany
	@JoinColumn(name = "patient_id")
	private List<History> history;

	public Patient() {
		super();
	}

	public Patient(Integer id, String name, String role, String location, String status, String preferredDoctorName,
			List<Nurse> nurses, List<Doctor> doctors, List<User> users, List<History> history) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.location = location;
		this.status = status;
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
