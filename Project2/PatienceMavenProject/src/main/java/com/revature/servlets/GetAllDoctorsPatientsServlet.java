package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Patient;
import com.revature.services.ObjectToJSONService;
import com.revature.services.PatientService;

/**
 * Servlet implementation class GetAllDoctorsPatientsServlet
 */
public class GetAllDoctorsPatientsServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(GetAllDoctorsPatientsServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllDoctorsPatientsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		PatientService ps = new PatientService();
		List<Patient> pl;
		
		pl = ps.getAll();
		//System.out.println("PL: " + pl);
		
		out.println(ObjectToJSONService.doctorsPatientsToJSON(pl));
		logger.info("GetAllDoctorsPatients returned JSON: " + ObjectToJSONService.doctorsPatientsToJSON(pl));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
