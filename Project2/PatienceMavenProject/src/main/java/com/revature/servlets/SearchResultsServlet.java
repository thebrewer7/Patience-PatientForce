package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.services.ObjectToJSONService;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseService;

/**
 * Servlet implementation class SearchResultsServlet
 */
public class SearchResultsServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(SearchResultsServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===="+this.getServletName()+"====");
		DoctorService doctorService = new DoctorService();
		NurseService nurseService = new NurseService();
		String name = request.getParameter("name");
		Doctor doctor = null;
		Nurse nurse = null;
		
		List<Doctor> receivedDoctors = doctorService.getByName(name);
		if ( receivedDoctors != null )
		{
			doctor = receivedDoctors.get(0);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(ObjectToJSONService.DoctorToJSON(doctor));
			logger.info("searchresultsservlet returned a doctor");
			return;
		}
		
		List<Nurse> receivedNurses = nurseService.getByName(name);
		if ( receivedNurses != null )
		{
			nurse = receivedNurses.get(0);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(ObjectToJSONService.NurseToJSON(nurse));
			logger.info("searchresultsservlet returned a nurse");
			return;
		}
		
		logger.info("SearchResultsServlet found more than one of the same name.");
		System.out.println("There is no users or more than 1 user with that name");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println();
		return; 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======POST======");
		
		doGet(request, response);
	}

}
