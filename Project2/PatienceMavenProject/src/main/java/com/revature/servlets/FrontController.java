package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	final static Logger logger = Logger.getLogger(FrontController.class);
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FrontController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		
		RequestDispatcher rd;
		
		String[] tokens = url.split("/");
		String action = (tokens[tokens.length-1]); //something.do
		
		action = action.substring(0, action.length()-3).toLowerCase();//something
		
		
		switch(action){
		case "searchresults":
			logger.info("FrontController: searchresults servlet hit.");
			rd = request.getRequestDispatcher("SearchResultsServlet");
			rd.forward(request, response);
			break;
		case "getuserspatients":
			logger.info("FrontController: getuserspatients servlet hit.");
			rd = request.getRequestDispatcher("getUsersPatientsServlet");
			rd.forward(request, response);
			break;
		case "editdoctorspatient":
			logger.info("FrontController: editdoctorspatient servlet hit.");
			rd = request.getRequestDispatcher("editPatientServlet");
			rd.forward(request, response);
			break;
		case "getnurses":
			logger.info("FrontController: getnurses servlet hit.");
			rd = request.getRequestDispatcher("getNursesServlet");
			rd.forward(request, response);
		case "login":
			logger.info("FrontController: login servlet hit.");
			rd = request.getRequestDispatcher("LoginServlet");
			rd.forward(request, response);
			break;
		case "submitreview":
			logger.info("FrontController: submitreview servlet hit.");
			rd = request.getRequestDispatcher("SubmitReviewServlet");
			rd.forward(request, response);
			break;
		case "fetchreview":
			logger.info("FrontController: fetchreviewservlet servlet hit.");
			rd = request.getRequestDispatcher("FetchReviewServlet");
			rd.forward(request, response);
			break;
		default:
			logger.info("FrontController: no corresponding servlet found.");
			response.sendError(404);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
