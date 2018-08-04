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
 * Servlet implementation class SearchResultsServlet
 */
public class SearchResultsServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(SearchResultsServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===="+this.getServletName()+"====");
		UserService userService = new UserService();
		String name = request.getParameter("name");
		UserAccount user = null;
		List<UserAccount> receivedUsers = userService.getByName(name.toLowerCase());
		
		if( receivedUsers == null || receivedUsers.size() > 1){
			logger.info("SearchResultsServlet found more than one of the same name.");
			System.out.println("There is no users or more than 1 user with that name");
		} else {
			user = receivedUsers.get(0);
		}
		
		System.out.println("returning user:" + name);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(ObjectToJSONService.UserAccountToJSON(user));
		logger.info("searchresultsservlet returned a json");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======POST======");
		
		doGet(request, response);
	}

}
