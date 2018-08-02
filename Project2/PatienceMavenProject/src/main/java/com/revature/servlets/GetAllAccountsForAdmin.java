package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.UserPass;
import com.revature.beans.nurse.Nurse;
import com.revature.services.ObjectToJSONService;
import com.revature.services.UserPassService;

/**
 * Servlet implementation class GetAllAccountsForAdmin
 */
public class GetAllAccountsForAdmin extends HttpServlet {
	final static Logger logger = Logger.getLogger(GetAllAccountsForAdmin.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllAccountsForAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		UserPassService ups = new UserPassService();
		List<UserPass> upl;
		
		upl = ups.getAll();
		System.out.println("UPL: " + upl);
		
		out.println(ObjectToJSONService.allAccountsToJSON(upl));
		logger.info("GetAllAccountsForAdmin returned JSON: " + ObjectToJSONService.allAccountsToJSON(upl));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
