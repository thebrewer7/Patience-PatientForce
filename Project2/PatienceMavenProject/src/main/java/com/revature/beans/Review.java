package com.revature.beans;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Review {
	@Id
	@SequenceGenerator(sequenceName = "review_seq", name = "review_seq")
	@GeneratedValue(generator = "review_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String role;
	private String name;
	private Integer rating;
	private String review;
	
	public Review() {
		super();
	}
	
	public Review(String name, Integer rating, String review) {
		super();
		this.name = name;
		this.rating = rating;
		this.review = review;
	}

	public Review(Integer rating, Role role, String review) {
		super();
		this.rating = rating;
		this.role = role.toString();
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
