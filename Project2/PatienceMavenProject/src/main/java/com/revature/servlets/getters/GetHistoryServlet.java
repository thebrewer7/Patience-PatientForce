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
import com.revature.beans.UserPass;
import com.revature.beans.history.History;
import com.revature.services.HistoryService;
import com.revature.services.ObjectToJSONService;
import com.revature.services.PatientService;
import com.revature.services.UserPassService;
import com.revature.services.UserService;

/**
 * Servlet implementation class GetHistoryServlet
 */
public class GetHistoryServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(GetHistoryServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHistoryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		
		History history = new History();
        UserPass userPass = new UserPass();
        Patient patient = new Patient();        
        userPass = new UserPassService().getByUsername("cellulating");
        patient = new PatientService().getByUserPass(userPass.getId());
        history = new HistoryService().getById(patient.getId());
		
		out.println(ObjectToJSONService.oneHistoryToJSON(history));
		logger.info("gethistory returned a list of histories");
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
