package com.revature.services;

import org.codehaus.jackson.map.ObjectMapper;

import com.revature.beans.Patient;
import com.revature.beans.Review;
import com.revature.beans.UserAccount;

public class ObjectToJSONService {
	public static String UserToJSONById(UserAccount user) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try {
			json = mapper.writeValueAsString(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public static String PatientToJSONByUsername(Patient patient)
	{
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try
		{
			json = mapper.writeValueAsString(patient);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		return json;
	}
	
	public static String PatientToJSONById(Patient patient)
	{
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try
		{
			json = mapper.writeValueAsString(patient);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		return json;
	}
	
	public static String ReviewsToJSONById(Review[] reviews)
	{
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try
		{
			json = mapper.writeValueAsString(reviews);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		return json;
	}
}
