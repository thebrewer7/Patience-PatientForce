package com.revature.beans.history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Vaccination {
	@Id
	@SequenceGenerator(sequenceName = "hstVac_seq", name = "hstVac_seq")
	@GeneratedValue(generator = "hstVac_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String vaccination;

	public Vaccination() {
		super();
	}

	public Vaccination(String vaccination) {
		super();
		this.vaccination = vaccination;
	}

	public String getVaccination() {
		return vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}

	public Integer getId() {
		return id;
	}

}
