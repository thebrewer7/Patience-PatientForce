package com.revature.beans.nurse;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NurseCerts {
	@Id
	private Integer id;
	private String cert;

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
