package com.revature.beans.history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Treatment {
	@Id
	@SequenceGenerator(sequenceName = "hstTreatment_seq", name = "hstTreatment_seq")
	@GeneratedValue(generator = "hstTreatment_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String treatment;

	public Treatment(String treatment) {
		super();
		this.treatment = treatment;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Integer getId() {
		return id;
	}

}
