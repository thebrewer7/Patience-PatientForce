package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.history.History;
import com.revature.services.HistoryService;
import com.revature.services.ObjectToJSONService;

/**
 * Servlet implementation class GetHistoryServlet
 */
public class GetHistoryServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(GetHistoryServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		HistoryService hs = new HistoryService();
		List<History> hl;
		
		hl = hs.getAll();
		
		out.println(ObjectToJSONService.historyToJSON(hl));
		logger.info("GetHistory returned JSON: " + ObjectToJSONService.historyToJSON(hl));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
