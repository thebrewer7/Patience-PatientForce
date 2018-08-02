package com.revature.services.nurse;

import com.revature.beans.nurse.NurseCerts;
import com.revature.services.GenericService;

public class NurseCertsService extends GenericService<NurseCerts> {
	public NurseCertsService() {
		super(new NurseCerts());
	}
}
