package com.revature.servlets.getters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.doctor.Doctor;
import com.revature.services.ObjectToJSONService;
import com.revature.services.doctor.DoctorService;

/**
 * Servlet implementation class GetDoctorsServlet
 */
public class GetDoctorsServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(GetDoctorsServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDoctorsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		DoctorService ds = new DoctorService();
		List<Doctor> dl;
		
		dl = ds.getAll();
		
		out.println(ObjectToJSONService.doctorsToJSON(dl));
		logger.info("GetDoctors returned JSON: " + ObjectToJSONService.doctorsToJSON(dl));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
