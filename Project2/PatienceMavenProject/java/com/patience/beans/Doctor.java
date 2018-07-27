package com.patience.beans;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Doctor")
public class Doctor {
	@Id
	@Column(name = "doctor_id")
	@SequenceGenerator(sequenceName = "doctor_seq", name = "doctor_seq")
	@GeneratedValue(generator = "doctor_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "doctor_name")
	private String name;
	@Column(name = "doctor_role")
	private String role;
	@Column(name = "doctor_certifications")
	private List<String> certifications;
	@Column(name = "doctor_degrees")
	private List<String> degrees;
	@Column(name = "doctor_experienc")
	private List<String> experience;

	@Column(name = "doctor_rating")
	private Integer rating;
	@Column(name = "doctor_reviews")
	private Review reviews;

	@Column(name = "doctor_department")
	private String department;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "patient_2_doctor", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private List<Patient> patients;

	public Doctor() {
		super();
	}

	public Doctor(Integer id, String name, String role, List<String> certifications, List<String> degrees,
			List<String> experience, Integer rating, Review reviews, String department, List<Patient> patients) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.certifications = certifications;
		this.degrees = degrees;
		this.experience = experience;
		this.rating = rating;
		this.reviews = reviews;
		this.department = department;
		this.patients = patients;
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

	public List<String> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<String> certifications) {
		this.certifications = certifications;
	}

	public List<String> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<String> degrees) {
		this.degrees = degrees;
	}

	public List<String> getExperience() {
		return experience;
	}

	public void setExperience(List<String> experience) {
		this.experience = experience;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Review getReviews() {
		return reviews;
	}

	public void setReviews(Review reviews) {
		this.reviews = reviews;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", role=" + role + ", certifications=" + certifications
				+ ", degrees=" + degrees + ", experience=" + experience + ", rating=" + rating + ", reviews=" + reviews
				+ ", department=" + department + ", patients=" + patients + "]";
	}

}
