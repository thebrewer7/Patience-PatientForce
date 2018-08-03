package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Patient;
import com.revature.services.ObjectToJSONService;
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
		editpatient.setLocation(patientlocation);
		editpatient.setStatus(patientstatus);
		
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		out.println("PatientID: " + patientid + " has been updated.");
		logger.info("editPatientServlet updated a patient");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
