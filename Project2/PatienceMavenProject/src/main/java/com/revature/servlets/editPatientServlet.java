package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.revature.beans.Patient;
import com.revature.services.PatientService;

/**
 * Servlet implementation class editPatientServlet
 */
public class editPatientServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(FrontController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPatientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer patientid = Integer.parseInt(request.getParameter("patientid"));
		String patientlocation = request.getParameter("patientlocation");
		String patientstatus = request.getParameter("patientstatus");
		PatientService ps = new PatientService();
		
		Patient editpatient = ps.getById(patientid);
		//logger.info("person before change :" + editpatient);
		editpatient.setLocation(patientlocation);
		editpatient.setStatus(patientstatus);
		//logger.info("person after change :" + editpatient);
		
		response.setContentType("text");
		
		PrintWriter out = response.getWriter();
		out.println();
		logger.info("editPatientServlet updated a patient");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
