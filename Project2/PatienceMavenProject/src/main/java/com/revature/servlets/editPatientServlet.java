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
	final static Logger logger = Logger.getLogger(editPatientServlet.class);
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
		logger.info("inside the editpatientservlet");
		Integer patientid = Integer.parseInt(request.getParameter("patientid"));
		String patientlocation = request.getParameter("patientlocation");
		String patientstatus = request.getParameter("patientstatus");
		logger.info("patientid in editpatientservlet: " + patientid);
		logger.info("patientlocation in editpatientservlet: " + patientlocation);
		logger.info("patientstatus in editpatientservlet: " + patientstatus);
		PatientService ps = new PatientService();
		
		Patient editpatient = ps.getById(patientid);
		
		String test = ObjectToJSONService.PatientToJSON(editpatient);
		System.out.println("editpatient: " + test);
		
		editpatient.setLocation(patientlocation);
		ps.saveOrUpdate(editpatient);
		editpatient.setStatus(patientstatus);
		ps.saveOrUpdate(editpatient);
		
		test = ObjectToJSONService.PatientToJSON(editpatient);
		System.out.println("editpatient: " + test);
		
//		ps.getById(patientid).setLocation(patientlocation);
//		ps.saveOrUpdate(ps.getById(patientid));
//		ps.getById(patientid).setStatus(patientstatus);
//		ps.saveOrUpdate(ps.getById(patientid));
		
		response.setContentType("text/json");
		
      	//String json = ObjectToJSONService.PatientToJSON(ps.getById(patientid));
		String json = ObjectToJSONService.PatientToJSON(editpatient);
		PrintWriter out = response.getWriter();
		out.println(json);
		logger.info("editPatientServlet updated a patient with patientid = " + patientid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
