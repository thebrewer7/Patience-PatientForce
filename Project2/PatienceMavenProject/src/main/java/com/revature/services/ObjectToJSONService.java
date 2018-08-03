package com.revature.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.revature.beans.Patient;
import com.revature.beans.Review;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;

public class ObjectToJSONService {
	
	public static String ReviewsToJSON(List<Review> reviews)
	{
		ObjectMapper mapper = new ObjectMapper();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd h:mm:ss a z");
		mapper.setDateFormat(dateFormat);
		String json = "";
		
		try
		{
			json = mapper.writeValueAsString(reviews);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		System.out.println("review JSON: "+json);
		return json;
	}

	public static String PatientToJSON(Patient patient) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(patient);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public static String UserAccountToJSON(UserAccount userAccount) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(userAccount);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public static String NurseToJSON(Nurse nurse) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(nurse);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public static String DoctorToJSON(Doctor doctor) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(doctor);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String nurseToJSON(Nurse nurse)
	{
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try
		{
			json = mapper.writeValueAsString(nurse);
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		return json;
	}
	
	public static String allAccountsToJSON(List<UserPass> upl)
	{
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try
		{
			json = mapper.writeValueAsString(upl);
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		return json;
	}
}
