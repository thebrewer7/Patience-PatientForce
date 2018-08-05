package com.revature.beans.doctor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Represents a doctoral medical degreed
 * @author Austin
 *
 */
@Entity
public class DocDegree {
	@Id
	@SequenceGenerator(sequenceName = "docDeg_seq", name = "docDeg_seq")
	@GeneratedValue(generator = "docDeg_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String degree;

	/**
	 * No-Args Constructor
	 */
	public DocDegree() {
		super();
	}

	/**
	 * Full instantiation
	 * @param degree
	 */
	public DocDegree(String degree) {
		super();
		this.degree = degree;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "DocDegree [id=" + id + ", degree=" + degree + "]";
	}
	
}
