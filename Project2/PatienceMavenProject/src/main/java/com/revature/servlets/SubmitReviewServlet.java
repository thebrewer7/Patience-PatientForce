package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	final static Logger logger = Logger.getLogger(SubmitReviewServlet.class);
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
		int id = Integer.parseInt(request.getParameter("id"));
		long date = Long.parseLong(request.getParameter("date").replace(",", ""));
		String role = request.getParameter("role");
		
		Review inReview = new Review(rating, review, new Date(date));
		new ReviewService().saveOrUpdate(inReview);
		Doctor doc = new Doctor();
		Nurse nur = new Nurse();
		List<Review> reviews = new ArrayList<>();
       
		switch(role.toLowerCase()) {
		case "doctor":
			doc = new DoctorService().getById(id);
			reviews = doc.getReviews();
			reviews.add(inReview);
			doc.setReviews(reviews);
			new DoctorService().saveOrUpdate(doc);
			break;
		case "nurse":
			nur = new NurseService().getById(id);
			reviews = nur.getReviews();
			reviews.add(inReview);
			nur.setReviews(reviews);
           	new NurseService().saveOrUpdate(nur);
           	break;
		}
		
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		out.println("server: received review");
		logger.info("SubmitReviewServlet received a review");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
