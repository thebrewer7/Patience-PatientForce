package com.revature.servlets.getters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.services.ObjectToJSONService;
import com.revature.services.UserPassService;
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
		
		List<Patient> patientList = new ArrayList<>();
		UserPass userPass = new UserPass();
		UserAccount user = new UserAccount();
		userPass = new UserPassService().getByUsername(username);
		user = new UserService().getByUserPass(userPass.getId());
		patientList = user.patients;
		
		out.println(ObjectToJSONService.toJson(patientList));
		logger.info("getuserspatientsservlet returned a list of patients");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
