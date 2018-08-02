package com.revature.services.doctor;

import com.revature.beans.doctor.DocDegree;
import com.revature.services.GenericService;

public class DocDegreeService extends GenericService<DocDegree> {
	public DocDegreeService() {
		super(new DocDegree());
	}
}
