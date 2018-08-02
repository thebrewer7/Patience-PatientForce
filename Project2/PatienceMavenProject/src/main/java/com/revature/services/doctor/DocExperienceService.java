package com.revature.services.doctor;

import com.revature.beans.doctor.DocExperience;
import com.revature.services.GenericService;

public class DocExperienceService extends GenericService<DocExperience> {
	public DocExperienceService() {
		super(new DocExperience());
	}
}
