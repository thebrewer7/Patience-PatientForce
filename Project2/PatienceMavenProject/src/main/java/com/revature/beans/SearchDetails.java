package com.revature.beans;

import java.util.Arrays;
import java.util.List;

import com.revature.beans.nurse.NurseCerts;

public class SearchDetails {
	private int id;
	private String name;
	private String role;
	private List<NurseCerts> certifications;
	private String[] degrees;
	private String experience;
	private int rating;
	private List<Review> reviews;
	private String department;
	private List<Patient> patients;
	
	public SearchDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchDetails(int id, String name, String role, List<NurseCerts> certifications, String[] degrees, String experience,
			int rating, List<Review> reviews, String department, List<Patient> patients) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.certifications = certifications;
		this.degrees = degrees;
		this.experience = experience;
		this.rating = rating;
		this.reviews = reviews;
		this.department = department;
		this.patients = patients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<NurseCerts> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<NurseCerts> certifications) {
		this.certifications = certifications;
	}

	public String[] getDegrees() {
		return degrees;
	}

	public void setDegrees(String[] degrees) {
		this.degrees = degrees;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "SearchDetails [id=" + id + ", name=" + name + ", role=" + role + ", certifications=" + certifications
				+ ", degrees=" + Arrays.toString(degrees) + ", experience=" + experience + ", rating=" + rating
				+ ", reviews=" + reviews + ", department=" + department + ", patients=" + patients + "]";
	}
	
}
