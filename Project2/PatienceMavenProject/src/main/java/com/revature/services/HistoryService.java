package com.revature.services;

import com.revature.beans.history.History;

public class HistoryService extends GenericService<History> {
	public HistoryService() {
		super(new History());
	}
}
