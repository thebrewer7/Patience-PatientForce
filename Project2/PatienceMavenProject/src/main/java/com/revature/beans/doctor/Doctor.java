package com.revature.beans.doctor;

import java.util.List;

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

import com.revature.beans.Patient;
import com.revature.beans.Review;

@Entity
public class Doctor {
	@Id
	@SequenceGenerator(sequenceName = "doctor_seq", name = "doctor_seq")
	@GeneratedValue(generator = "doctor_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToMany(mappedBy="Doctor")
	@JoinColumn(name="cert_id")
	private List<DocCerts> certifications;
	@OneToMany(mappedBy="Doctor")
	@JoinColumn(name="cert_id")
	private List<DocDegree> degrees;
	@OneToMany(mappedBy="Doctor")
	@JoinColumn(name="cert_id")
	private List<DocExperience> experience;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "patient_2_doctor", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private List<Patient> patients;

	private Integer rating;
	private Review reviews;
	private String name;
	private String role;
	private String department;

	public Doctor() {
		super();
	}

	public Doctor(String name, String role, List<DocCerts> certifications, List<DocDegree> degrees,
			List<DocExperience> experience, Integer rating, Review reviews, String department, List<Patient> patients) {
		super();
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

	public List<DocCerts> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<DocCerts> certifications) {
		this.certifications = certifications;
	}

	public List<DocDegree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<DocDegree> degrees) {
		this.degrees = degrees;
	}

	public List<DocExperience> getExperience() {
		return experience;
	}

	public void setExperience(List<DocExperience> experience) {
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
