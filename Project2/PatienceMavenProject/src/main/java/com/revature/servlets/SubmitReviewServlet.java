package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Review;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.services.ReviewService;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseService;

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
		System.out.println("===="+this.getServletName()+"====");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String review = request.getParameter("review");
		int id = Integer.parseInt(request.getParameter("id"));
		long date = Long.parseLong(request.getParameter("date").replace(",", ""));
		String role = request.getParameter("role");
		
		Review inReview = new Review(rating, review, new Date(date));
		
		Doctor doc = null;
		Nurse nur = null;
		
		switch(role.toLowerCase()) {
		case "doctor":
			doc = new DoctorService().getById(id);
			doc.setReviews(Arrays.asList(new Review[] {inReview}));
			break;
		case "nurse":
			nur = new NurseService().getById(id);
			nur.setReviews(Arrays.asList(new Review[] {inReview}));
			break;
		}
		
		new ReviewService().saveOrUpdate(inReview);
		new DoctorService().saveOrUpdate(doc);
		
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		System.out.println("review: "+inReview);
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
