package com.revature.beans.nurse;

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
public class Nurse {
	@Id
	@SequenceGenerator(sequenceName = "nurse_seq", name = "nurse_seq")
	@GeneratedValue(generator = "nurse_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToMany
	private List<NurseCerts> certifications;
	@OneToMany
	private List<Review> reviews;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "patient_2_nurse", joinColumns = @JoinColumn(name = "nurse_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private List<Patient> patients;

	private String name;
	private String department;
	private Blob profilePicture;
	private Integer rating;
	private final String ROLE = "nurse";

	public Nurse() {
		super();
	}
	
	public Nurse(String name)
	{
		super();
		this.name = name;
	}

	public Nurse(String name, List<NurseCerts> certifications, String department, Integer rating, List<Review> reviews,
			List<Patient> patients) {
		super();
		this.name = name;
		this.certifications = certifications;
		this.department = department;
		this.rating = rating;
		this.reviews = reviews;
		this.patients = patients;
	}

	public Nurse(List<NurseCerts> certifications, List<Review> reviews, List<Patient> patients, String name,
			String department, Blob profilePicture, Integer rating) {
		super();
		this.certifications = certifications;
		this.reviews = reviews;
		this.patients = patients;
		this.name = name;
		this.department = department;
		this.profilePicture = profilePicture;
		this.rating = rating;
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

	public List<NurseCerts> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<NurseCerts> certifications) {
		this.certifications = certifications;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Nurse [id=" + id + ", name=" + name + ", role=" + ROLE + ", certifications=" + certifications
				+ ", department=" + department + ", rating=" + rating + ", reviews=" + reviews + ", patients="
				+ patients + "]";
	}

}
