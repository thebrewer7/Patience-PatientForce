package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
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
		//System.out.println("====" + this.getServletName() + "====");
		String url = request.getRequestURI(); //Stores the url in a string (minues the http jargon)
		//System.out.println(url);			  //localhost:8085/something.do
		
		RequestDispatcher rd;
		
		String[] tokens = url.split("/");
		String action = (tokens[tokens.length-1]); //something.do
		
		action = action.substring(0, action.length()-3).toLowerCase();//something
		
		
		switch(action){
		case "searchresults":
			rd = request.getRequestDispatcher("/SearchResultsServlet");
			rd.forward(request, response);
			break;
		case "getuserspatients":
			rd = request.getRequestDispatcher("/getUsersPatientsServlet");
			rd.forward(request, response);
			break;
		case "editdoctorspatient":
			rd = request.getRequestDispatcher("/editPatientServlet");
			rd.forward(request, response);
			break;
		default:
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
