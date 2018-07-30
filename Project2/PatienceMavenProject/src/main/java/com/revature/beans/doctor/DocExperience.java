package com.revature.beans.doctor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class DocExperience {
	@Id
	@SequenceGenerator(sequenceName = "docExp_seq", name = "docExp_seq")
	@GeneratedValue(generator = "docExp_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String experience;

	public DocExperience(String experience) {
		super();
		this.experience = experience;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
}
