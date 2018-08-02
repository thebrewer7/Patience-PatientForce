package com.revature.beans;

import java.util.Date;

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

	private String name;
	private Date datePosted;
	private Integer rating;
	private String review;

	public Review() {
		super();
	}

	/**
	 * 
	 * @param rating
	 * @param review
	 * @param datePosted
	 */
	public Review(Integer rating, String review, Date datePosted) {
		super();
		this.datePosted = datePosted;
		this.rating = rating;
		this.review = review;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
}
