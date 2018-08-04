package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.SearchDetails;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.services.ObjectToJSONService;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseService;

/**
 * Servlet implementation class GetAllUsersServlet
 */
public class GetAllUsersServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(GetAllUsersServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllUsersServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===="+this.getServletName()+"====");
		
		List<Doctor> docs = new DoctorService().getAll();
		List<Nurse> nurs = new NurseService().getAll();
		List<SearchDetails> sdets = new ArrayList<SearchDetails>();
		
		for(Doctor doc: docs) {
			sdets.add(new SearchDetails(doc.getId(), doc.getName(), doc.getROLE(), null, new String[] {}, "", doc.getRating(), 
					doc.getReviews(), doc.getDepartment(), doc.patients));
		}
		for(Nurse nur: nurs) {
			sdets.add(new SearchDetails(nur.getId(), nur.getName(), nur.getRole(), nur.getCertifications(), new String[] {}, "", 
					nur.getRating(), nur.getReviews(), nur.getDepartment(), nur.patients));
		}
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.println(ObjectToJSONService.SeachDetailsToJSON(sdets));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
