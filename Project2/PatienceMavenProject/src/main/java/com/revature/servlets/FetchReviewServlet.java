package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Review;
import com.revature.services.ObjectToJSONService;

/**
 * Servlet implementation class FetchReviewServlet
 */
public class FetchReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===="+this.getServletName()+"====");
		
		String name = request.getParameter("name");
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(ObjectToJSONService.ReviewsToJSON(new Review[] {new Review(name, 1533161580851.0, 3, "test review"),
														new Review(name, 1533161630780.0, 2, "test review 2"),
														new Review(name, 1533161539687.0, 2, "test review 3")})); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
