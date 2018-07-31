package com.revature.beans.doctor;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.revature.beans.Patient;
import com.revature.beans.Review;
import com.revature.beans.UserPass;

@Entity
public class Doctor {
	@Id
	@SequenceGenerator(sequenceName = "doctor_seq", name = "doctor_seq")
	@GeneratedValue(generator = "doctor_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToOne
	private DocBackground background;
	@OneToMany
	private List<Review> reviews;
	@OneToOne
	private UserPass userPass;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Patient> patients;

	private Integer rating;
	private String name;
	private final String ROLE = "doctor";
	private String department;
	private Blob profilePicture;

	public Doctor() {
		super();
	}

	public Doctor(DocBackground background, List<Review> reviews, UserPass userPass, List<Patient> patients,
			Integer rating, String name, String department) {
		super();
		this.background = background;
		this.reviews = reviews;
		this.userPass = userPass;
		this.patients = patients;
		this.rating = rating;
		this.name = name;
		this.department = department;
	}

	public Doctor(DocBackground background, List<Review> reviews, UserPass userPass, List<Patient> patients,
			Integer rating, String name, String department, Blob profilePicture) {
		super();
		this.background = background;
		this.reviews = reviews;
		this.userPass = userPass;
		this.patients = patients;
		this.rating = rating;
		this.name = name;
		this.department = department;
		this.profilePicture = profilePicture;
	}

	public DocBackground getBackground() {
		return background;
	}

	public void setBackground(DocBackground background) {
		this.background = background;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public UserPass getUserPass() {
		return userPass;
	}

	public void setUserPass(UserPass userPass) {
		this.userPass = userPass;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Blob getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Blob profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Integer getId() {
		return id;
	}

	public String getROLE() {
		return ROLE;
	}

	
}
