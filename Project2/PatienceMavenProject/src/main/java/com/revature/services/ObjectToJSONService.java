package com.revature.services;

import org.codehaus.jackson.map.ObjectMapper;

import com.revature.beans.User;

public class ObjectToJSONService {
	public static String UserToJSONById(User user) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try {
			json = mapper.writeValueAsString(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
