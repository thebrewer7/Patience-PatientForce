package com.revature.services;

import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import org.codehaus.jackson.map.ObjectMapper;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;

public class ObjectToJSONService {

	/* **********************************************/

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

	/* ********************************************/


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
}
