package com.revature.beans.nurse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class NurseCerts {
	@Id
	@SequenceGenerator(sequenceName = "nurseCerts_seq", name = "nurseCerts_seq")
	@GeneratedValue(generator = "nurseCerts_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String cert;

	public NurseCerts() {
		super();
	}

	public NurseCerts(String cert) {
		super();
		this.cert = cert;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

}
