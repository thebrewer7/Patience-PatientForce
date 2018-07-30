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
}
