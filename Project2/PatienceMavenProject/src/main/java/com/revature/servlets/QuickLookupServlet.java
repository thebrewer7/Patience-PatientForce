package com.revature.servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.revature.beans.Patient;
import com.revature.services.ObjectToJSONService;
import com.revature.services.PatientService;
import org.apache.log4j.Logger;

public class QuickLookupServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(QuickLookupServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        logger.info("Search: " + username);
        PatientService ps = new PatientService();
        List<Patient> patients = ps.getByName(username);

        response.setContentType("text/json");
        PrintWriter writer = response.getWriter();

        if (patients.size() > 0) {
            writer.println(ObjectToJSONService.PatientToJSON(patients.get(0)));
        } else {
            writer.println("{ \"status\": \"search failure\", \"message:\": \"No patient by username\" }");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
