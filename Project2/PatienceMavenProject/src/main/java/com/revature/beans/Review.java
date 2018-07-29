package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import com.revature.beans.interfaces.Role;

@AnyMetaDef(name = "ReviewMetaDef", metaType = "string", idType = "int", metaValues = {
		@MetaValue(value = "user", targetEntity = User.class),
		@MetaValue(value = "patient", targetEntity = Patient.class),
		@MetaValue(value = "nurse", targetEntity = Nurse.class),
		@MetaValue(value = "doctor", targetEntity = Doctor.class),
		@MetaValue(value = "admin", targetEntity = Admin.class) 
})

@Entity
@Table(name = "Review")
public class Review {
	@Id
	@Column(name = "review_id")
	@SequenceGenerator(sequenceName = "review_seq", name = "review_seq")
	@GeneratedValue(generator = "review_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "review_rating")
	private Integer rating;
	@Column(name = "review_review")
	private String review;
	@Any(metaDef="ReviewMetaDef", metaColumn = @Column(name = "review_role"))
	@JoinColumn(name="role_id")
	private Role role;

	public Review() {
		super();
	}

	public Review(Integer id, Integer rating, Role role, String review) {
		super();
		this.id = id;
		this.rating = rating;
		this.role = role;
		this.review = review;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
