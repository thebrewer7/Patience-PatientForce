package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Patient;
import com.revature.services.ObjectToJSONService;
import com.revature.services.PatientService;

public class QuickLookupServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(QuickLookupServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        logger.info("Search: " + username);
        PatientService ps = new PatientService();
        List<Patient> patients = ps.getByName(username);

        response.setContentType("text/json");
        PrintWriter writer = response.getWriter();

        if (patients != null && patients.size() > 0) {
            writer.println(ObjectToJSONService.toJson(patients.get(0)));
        } else {
            writer.println("{ \"status\": \"search failure\", \"message:\": \"No patient by username\" }");
            logger.info("QuickLookup failed to find that patient by that name");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
