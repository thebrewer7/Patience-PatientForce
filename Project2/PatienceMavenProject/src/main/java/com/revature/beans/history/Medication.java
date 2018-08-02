package com.revature.beans.history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Medication {
	@Id
	@SequenceGenerator(sequenceName = "hstMed_seq", name = "hstMed_seq")
	@GeneratedValue(generator = "hstMed_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String medication;

	public Medication() {
		super();
	}

	public Medication(String medication) {
		super();
		this.medication = medication;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public Integer getId() {
		return id;
	}

}
