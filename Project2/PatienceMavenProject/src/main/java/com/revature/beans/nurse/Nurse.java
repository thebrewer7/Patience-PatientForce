package com.revature.beans.nurse;

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
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.revature.beans.Patient;
import com.revature.beans.Review;
import com.revature.beans.UserPass;


@Entity
public class Nurse {
	@Id
	@SequenceGenerator(sequenceName = "nurse_seq", name = "nurse_seq")
	@GeneratedValue(generator = "nurse_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToMany(fetch=FetchType.EAGER)
	private List<NurseCerts> certifications;
	@OneToMany(fetch=FetchType.EAGER)
	private List<Review> reviews;
	@OneToOne
	private UserPass userPass;
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)
	public List<Patient> patients;

	private String name;
	private String department;
	private Blob profilePicture;
	private Integer rating;
	private final String ROLE = "nurse";

	/**
	 * No args constructor
	 */
	public Nurse() {
		super();
	}

	public Nurse(String name) {
		super();
		this.name = name;
	}

	@Transient
	private int avg = 0;

	/**
	 * 
	 * @param certifications
	 * @param reviews
	 * @param userPass
	 * @param name
	 * @param department
	 *            Note: Also, instantiates rating
	 */
	public Nurse(List<NurseCerts> certifications, List<Review> reviews, UserPass userPass, String name,
			String department) {
		super();
		this.certifications = certifications;
		this.reviews = reviews;
		this.userPass = userPass;
		this.name = name;
		this.department = department;
		setRatingWithReviews(reviews);
	}

	/**
	 * Full instantiation excluding profile picture
	 * 
	 * @param certifications
	 * @param reviews
	 * @param userPass
	 * @param patients
	 * @param name
	 * @param department
	 * @param rating
	 */
	public Nurse(List<NurseCerts> certifications, List<Review> reviews, UserPass userPass, List<Patient> patients,
			String name, String department, Integer rating) {
		super();
		this.certifications = certifications;
		this.reviews = reviews;
		this.userPass = userPass;
		this.patients = patients;
		this.name = name;
		this.department = department;
		setRatingWithReviews(reviews);
	}

	/**
	 * Full instantiation including profile picture
	 * 
	 * @param certifications
	 * @param reviews
	 * @param userPass
	 * @param patients
	 * @param name
	 * @param department
	 * @param profilePicture
	 * @param rating
	 *
	 */
	public Nurse(List<NurseCerts> certifications, List<Review> reviews, UserPass userPass, List<Patient> patients,
			String name, String department, Blob profilePicture, Integer rating) {
		super();
		this.certifications = certifications;
		this.reviews = reviews;
		this.userPass = userPass;
		this.patients = patients;
		this.name = name;
		this.department = department;
		this.profilePicture = profilePicture;
		setRatingWithReviews(reviews);
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

	public void setRatingWithReviews(List<Review> reviews) {
		reviews.forEach(review -> avg += review.getRating());
		this.rating = avg / reviews.size();
	}

	public UserPass getUserPass() {
		return userPass;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	@Override
	public String toString() {
		return "Nurse [id=" + id + ", certifications=" + certifications + ", name=" + name + ", department="
				+ department + ", rating=" + rating + ", ROLE=" + ROLE + ", avg=" + avg + "]";
	}

}
