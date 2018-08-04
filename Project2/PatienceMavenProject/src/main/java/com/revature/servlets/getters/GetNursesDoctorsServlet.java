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
 * Servlet implementation class GetNursesDoctorsServlet
 */
public class GetNursesDoctorsServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(GetNursesDoctorsServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNursesDoctorsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		DoctorService ps = new DoctorService();
		List<Doctor> dl;
		
		dl = ps.getAll();
		
		out.println(ObjectToJSONService.nursesDoctorsToJSON(dl));
		logger.info("getallnursesdoctors return a list of doctors");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
