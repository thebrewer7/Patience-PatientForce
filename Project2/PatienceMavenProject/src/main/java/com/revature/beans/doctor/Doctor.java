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
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.revature.beans.Patient;
import com.revature.beans.Review;
import com.revature.beans.UserPass;
/**
 * Represents a doctor and the relations ships that associate them to their patients
 * @author Austin
 *
 */
@Entity
public class Doctor {
	@Id
	@SequenceGenerator(sequenceName = "doctor_seq", name = "doctor_seq")
	@GeneratedValue(generator = "doctor_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToOne(fetch=FetchType.EAGER)
	private DocBackground background;
	@OneToMany
	private List<Review> reviews;
	@OneToOne
	private UserPass userPass;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	public List<Patient> patients;

	private Integer rating;
	private String name;
	private final String ROLE = "doctor";
	private String department;
	private Blob profilePicture;

	/**
	 * No-Args Constructor
	 */
	public Doctor() {
		super();
	}
	/**
	 * Creates an unassociated doctor containing history
	 * @param background
	 * @param reviews
	 * @param userPass
	 * @param name
	 * @param department
	 */
	public Doctor(DocBackground background, List<Review> reviews, UserPass userPass, String name, String department) {
		super();
		this.background = background;
		this.reviews = reviews;
		this.userPass = userPass;
		this.name = name;
		this.department = department;
		setRatingWithReviews(reviews);
	}

	/**
	 * A fully instantiated
	 * @param background
	 * @param reviews
	 * @param userPass
	 * @param patients
	 * @param name
	 * @param department
	 */
	public Doctor(DocBackground background, List<Review> reviews, UserPass userPass, List<Patient> patients,
			String name, String department) {
		super();
		this.background = background;
		this.reviews = reviews;
		this.userPass = userPass;
		this.patients = patients;
		setRatingWithReviews(reviews);
		this.name = name;
		this.department = department;
	}

	public Doctor(DocBackground background, List<Review> reviews, UserPass userPass, List<Patient> patients,
			String name, String department, Blob profilePicture) {
		super();
		this.background = background;
		this.reviews = reviews;
		this.userPass = userPass;
		this.patients = patients;
		setRatingWithReviews(reviews);
		this.name = name;
		this.department = department;
		this.profilePicture = profilePicture;
	}

	@Transient
	private int avg = 0;

	public void setRatingWithReviews(List<Review> reviews) {
		reviews.forEach(review -> avg += review.getRating());
		this.rating = avg / reviews.size();
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
