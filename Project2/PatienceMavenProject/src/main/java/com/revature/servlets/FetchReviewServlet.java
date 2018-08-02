package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Patient;
import com.revature.beans.Review;
import com.revature.services.ObjectToJSONService;

/**
 * Servlet implementation class FetchReviewServlet
 */
public class FetchReviewServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(FrontController.class);
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
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		String name = request.getParameter("name");
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(ObjectToJSONService.ReviewsToJSON(new Review[] {new Review(name, formatter.format(date), 3, "test review"),
														new Review(name, formatter.format(date), 2, "test review 2")}));
		logger.info("FetchReviewServlet returned JSON: " + ObjectToJSONService.ReviewsToJSON(new Review[] {new Review(name, formatter.format(date), 3, "test review"),
																							 new Review(name, formatter.format(date), 2, "test review 2")}));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
