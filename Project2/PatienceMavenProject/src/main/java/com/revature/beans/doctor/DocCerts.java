package com.revature.beans.doctor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class DocCerts {
	@Id
	@SequenceGenerator(sequenceName = "docCert_seq", name = "docCert_seq")
	@GeneratedValue(generator = "docCert_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String cert;

	public DocCerts() {
		super();
	}

	public DocCerts(String cert) {
		super();
		this.cert = cert;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}
}
