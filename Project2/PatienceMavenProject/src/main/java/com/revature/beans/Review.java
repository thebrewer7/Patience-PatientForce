package com.revature.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Review {
	@Id
	@SequenceGenerator(sequenceName = "review_seq", name = "review_seq")
	@GeneratedValue(generator = "review_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Temporal(value = TemporalType.TIMESTAMP)
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

	public Date getDate() {
		return datePosted;
	}

	public void setDate(Date date) {
		this.datePosted = date;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", date=" + datePosted + ", rating=" + rating
				+ ", review=" + review + "]";
	}

}
