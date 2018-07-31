package com.revature.beans.doctor;

import java.sql.Blob;
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

	@OneToMany
	private List<DocCerts> certifications;
	@OneToMany
	private List<DocDegree> degrees;
	@OneToMany
	private List<DocExperience> experience;
	@OneToMany
	private List<Review> reviews;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "patient_2_doctor", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private List<Patient> patients;

	private Integer rating;
	private String name;
	private final String ROLE = "doctor";
	private String department;
	private Blob profilePicture;

	public Doctor() {
		super();
	}

	public Doctor(String name, List<DocCerts> certifications, List<DocDegree> degrees, List<DocExperience> experience,
			Integer rating, List<Review> reviews, String department, List<Patient> patients) {
		super();
		this.name = name;
		this.certifications = certifications;
		this.degrees = degrees;
		this.experience = experience;
		this.rating = rating;
		this.reviews = reviews;
		this.department = department;
		this.patients = patients;
	}

	public Doctor(List<DocCerts> certifications, List<DocDegree> degrees, List<DocExperience> experience,
			List<Patient> patients, Integer rating, List<Review> reviews, String name, String department,
			Blob profilePicture) {
		super();
		this.certifications = certifications;
		this.degrees = degrees;
		this.experience = experience;
		this.patients = patients;
		this.rating = rating;
		this.reviews = reviews;
		this.name = name;
		this.department = department;
		this.profilePicture = profilePicture;
	}

	public Integer getId() {
		return id;
	}

	public Blob getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Blob profilePicture) {
		this.profilePicture = profilePicture;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
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
		return "Doctor [id=" + id + ", name=" + name + ", role=" + ROLE + ", certifications=" + certifications
				+ ", degrees=" + degrees + ", experience=" + experience + ", rating=" + rating + ", reviews=" + reviews
				+ ", department=" + department + ", patients=" + patients + "]";
	}

}
