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
		String name = request.getParameter("name");

		DoctorService doctorService = new DoctorService();
		List<Doctor> receivedDoctors = doctorService.getByName(name);
		if ( receivedDoctors != null )
		{
			Doctor doctor = receivedDoctors.get(0);
			response.setContentType("text/json");
			PrintWriter out = response.getWriter();
			out.println(ObjectToJSONService.toJson(doctor));
			logger.info("searchresultsservlet returned a doctor");
			return;
		}

		NurseService nurseService = new NurseService();
		List<Nurse> receivedNurses = nurseService.getByName(name);
		if ( receivedNurses != null )
		{
			Nurse nurse = receivedNurses.get(0);
			response.setContentType("text/json");
			PrintWriter out = response.getWriter();
			out.println(ObjectToJSONService.toJson(nurse));
			logger.info("searchresultsservlet returned a nurse");
			return;
		}
		
		logger.info("SearchResultsServlet found more than one of the same name.");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println((String)null);
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
