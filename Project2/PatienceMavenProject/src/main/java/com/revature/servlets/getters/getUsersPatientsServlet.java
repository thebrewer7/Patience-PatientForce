package com.revature.servlets.getters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;
import com.revature.services.ObjectToJSONService;
import com.revature.services.PatientService;
import com.revature.services.UserService;

/**
 * Servlet implementation class getUsersPatientsServlet
 */
public class getUsersPatientsServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(getUsersPatientsServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUsersPatientsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		PatientService ps = new PatientService();
		UserService us = new UserService();
		
		List<Patient> pl;
		
		pl = us.getByName(username).get(0).patients;
		
		out.println(ObjectToJSONService.patientsToJSON(pl));
		logger.info("getuserspatientsservlet returned a list of patients");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
