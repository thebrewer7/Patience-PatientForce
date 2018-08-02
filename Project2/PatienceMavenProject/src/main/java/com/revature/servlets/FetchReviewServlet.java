package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===="+this.getServletName()+"====");
		
		String name = request.getParameter("name");
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		
//		String date1 = "";
//		String date2 = "";
//		String date3 = "";
		
		try {
			date1 = new Date();
			TimeUnit.SECONDS.sleep(1);
			date2 = new Date();
			TimeUnit.SECONDS.sleep(1);
			date3 = new Date();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			date1 = dateFormat.format(new java.util.Date());
//			TimeUnit.SECONDS.sleep(5);
//			date2 = dateFormat.format(new java.util.Date());
//			TimeUnit.SECONDS.sleep(5);
//			date3 = dateFormat.format(new java.util.Date());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		out.println(ObjectToJSONService.ReviewsToJSON(new Review[] {new Review(3, "test review", date2),
														new Review(2, "test review 2", date3),
														new Review(2, "test review 3", date1)})); 
		logger.info("FetchReviewServlet returned JSON: " + new Review(3, "test review", date2));
		logger.info("FetchReviewServlet returned JSON: " + new Review(2, "test review 2", date3));
		logger.info("FetchReviewServlet returned JSON: " + new Review(2, "test review 3", date1));
		
//		out.println(ObjectToJSONService.ReviewsToJSON(new Review[] {new Review(name, date2, 3, "test review"),
//				new Review(name, date3, 2, "test review 2"),
//				new Review(name, date1, 2, "test review 3")})); 
//		logger.info("FetchReviewServlet returned JSON: " + new Review(name, date2, 3, "test review"));
//		logger.info("FetchReviewServlet returned JSON: " + new Review(name, date3, 2, "test review 2"));
//		logger.info("FetchReviewServlet returned JSON: " + new Review(name, date1, 2, "test review 3"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
