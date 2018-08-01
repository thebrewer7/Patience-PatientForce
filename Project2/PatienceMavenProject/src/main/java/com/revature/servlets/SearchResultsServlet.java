package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.UserAccount;
import com.revature.services.ObjectToJSONService;
import com.revature.services.UserService;

/**
 * Servlet implementation class SearchResultsServlet
 */
public class SearchResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		if(receivedUsers.size() > 1){
			System.out.println("There is more than one user with the same name!");
		} else {
			user = receivedUsers.get(0);
		}
		
		System.out.println("returning user:" + name);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(ObjectToJSONService.UserToJSONById(user));// TODO grab user using user dao
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======POST======");
		
		doGet(request, response);
	}

}
