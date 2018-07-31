package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Patient;
import com.revature.services.ObjectToJSONService;

/**
 * Servlet implementation class getUsersPatientsServlet
 */
public class getUsersPatientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUsersPatientsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String patientname = request.getParameter("patientname");
		String patientstatus = request.getParameter("patientstatus");
		String patientlocation = request.getParameter("patientlocation");
		
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		out.println(ObjectToJSONService.PatientToJSONByUsername(new Patient(patientname, patientlocation, patientstatus)));// TODO 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
