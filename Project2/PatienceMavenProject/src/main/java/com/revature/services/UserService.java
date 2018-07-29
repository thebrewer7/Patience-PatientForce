package com.revature.services;

import org.codehaus.jackson.map.ObjectMapper;

import com.revature.beans.User;

public class UserService {
	public static User getUserById(int id) {
		return new User(id, "test");
	}
	public static String getUserJSONById(int id) {
		User user = getUserById(id);
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
