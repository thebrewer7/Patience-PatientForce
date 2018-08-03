package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.UserAccount;
import com.revature.services.ObjectToJSONService;
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
		PrintWriter out = response.getWriter();
		UserService us = new UserService();
		List<UserAccount> ul;
		
		ul = us.getAll();
		
		out.println(ObjectToJSONService.userAccountsToJSON(ul));
		logger.info("getUsersPatientsServlet returned JSON: " + ObjectToJSONService.userAccountsToJSON(ul));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
