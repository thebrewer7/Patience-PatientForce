package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Patient;
import com.revature.services.ObjectToJSONService;

/**
 * Servlet implementation class getUsersPatientsServlet
 */
public class getUsersPatientsServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(FrontController.class);
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
		
		Integer patientid = Integer.parseInt(request.getParameter("patientid"));
		//System.err.println(this.getServletContext().getInitParameter("userpassid"));
		
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
		
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		out.println(ObjectToJSONService.PatientToJSON(new Patient("BlahFromDb", patientid, saltStr, saltStr)));// TODO 
		logger.info("getUsersPatientsServlet returned JSON: " + ObjectToJSONService.PatientToJSON(new Patient("BlahFromDb", patientid, saltStr, saltStr)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
