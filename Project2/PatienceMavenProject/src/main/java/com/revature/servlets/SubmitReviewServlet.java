package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class SubmitReviewServlet
 */
public class SubmitReviewServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(FrontController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReviewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rating = Integer.parseInt(request.getParameter("rating"));
		String review = request.getParameter("review");
		String name = request.getParameter("name");
		Date date = Date.valueOf(request.getParameter("date"));
		
		// TODO use rating dao to submit above information
		
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		System.out.println("Rating: "+rating+"\nReview: "+review+"\nName: "+name+"\nDate: "+date);
		out.println("server: received review");
		logger.info("SubmitReviewServlet received a review");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
