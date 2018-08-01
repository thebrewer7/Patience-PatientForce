package com.revature.beans.history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Diagnosis {
	@Id
	@SequenceGenerator(sequenceName = "hstDiag_seq", name = "hstDiag_seq")
	@GeneratedValue(generator = "hstDiag_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String diagnosis;

	public Diagnosis() {
		super();
	}

	public Diagnosis(String diagnosis) {
		super();
		this.diagnosis = diagnosis;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Integer getId() {
		return id;
	}

}
