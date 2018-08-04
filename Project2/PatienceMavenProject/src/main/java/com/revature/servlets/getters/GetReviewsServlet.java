package com.revature.servlets.getters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Review;
import com.revature.beans.doctor.Doctor;
import com.revature.services.ObjectToJSONService;
import com.revature.services.doctor.DoctorService;
import com.revature.servlets.FrontController;

/**
 * Servlet implementation class FetchReviewServlet
 */
public class GetReviewsServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(FrontController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReviewsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===="+this.getServletName()+"====");
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Doctor doc = new DoctorService().getById(id);
		
		List<Review> reviews = doc.getReviews();
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		

		out.println(ObjectToJSONService.ReviewsToJSON(reviews));
		logger.info("getreviewsservlet returned a list of reviews");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
