package com.revature.services.doctor;

import com.revature.beans.doctor.DocCerts;
import com.revature.services.GenericService;

public class DocCertsService extends GenericService<DocCerts> {
	public DocCertsService() {
		super(new DocCerts());
	}
}
