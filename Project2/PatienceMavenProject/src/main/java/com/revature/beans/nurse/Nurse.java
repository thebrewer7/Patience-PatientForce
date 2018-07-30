package com.revature.beans;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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

@Entity
@Table(name = "Nurse")
public class Nurse {
	@Id
	@Column(name = "nurse_id")
	@SequenceGenerator(sequenceName = "nurse_seq", name = "nurse_seq")
	@GeneratedValue(generator = "nurse_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "nurse_name")
	private String name;
	@Column(name = "nurse_role")
	private String role;

	@ElementCollection
	@CollectionTable(name="NCerts", joinColumns=@JoinColumn(name="certificate_id"))
	@Column(name = "nurse_certifications")
	private List<String> certifications;
	@Column(name = "nurse_department")
	private String department;
	@Column(name = "nurse_rating")
	private Integer rating;
	@OneToMany
	@JoinColumn(name = "nurse_review_id")
	private List<Review> reviews;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "patient_2_nurse", joinColumns = @JoinColumn(name = "nurse_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private List<Patient> patients;

	public Nurse() {
		super();
	}

	public Nurse(Integer id, String name, String role, List<String> certifications, String department, Integer rating,
			List<Review> reviews, List<Patient> patients) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.certifications = certifications;
		this.department = department;
		this.rating = rating;
		this.reviews = reviews;
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
		return "Nurse [id=" + id + ", name=" + name + ", role=" + role + ", certifications=" + certifications
				+ ", department=" + department + ", rating=" + rating + ", reviews=" + reviews + ", patients="
				+ patients + "]";
	}

}
