package com.revature.servlets;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.services.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.info("Username: " + username + " Password: " + password);

        //UserPassService ups = new UserPassService();
        //UserPass up = ups.getUserPassByUsername(username);

        response.setContentType("text/json");
        PrintWriter writer = response.getWriter();
        /*
        if (up.getPassword().equals(password)) {
            String json = "";
            logger.info("User is of type: " + up.getType());
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("role", up.getType()));

            switch (up.getType()) {
                case "user":
                    UserService us = new UserService();
                    UserAccount user = us.getByName(username).get(0);
                    json = ObjectToJSONService.UserAccountToJSON(user);
                    break;
                case "patient":
                    PatientService ps = new PatientService();
                    Patient patient = ps.getByName(username).get(0);
                    json = ObjectToJSONService.PatientToJSONById(patient);
                    break;
                case "nurse":
                    NurseService ns = new NurseService();
                    Nurse nurse = ns.getByName(username).get(0);
                    json = ObjectToJSONService.NurseToJSON(nurse);
                    break;
                case "doctor":
                    DoctorService ds = new DoctorService();
                    Doctor doctor = ds.getByName(username).get(0);
                    json = ObjectToJSONService.DoctorToJSON(doctor);
                    break;
            }
            writer.println(json);
        } else {
            UserAccount user  = new UserAccount(username);

            logger.info("Login failed");
            writer.println(ObjectToJSONService.UserAccountToJSON(user));
        }
        */

        // testing remove later
        UserAccount user  = new UserAccount(username);
        user.setRole(username);
        String json = ObjectToJSONService.UserAccountToJSON(user);
        System.out.println(json);

        writer.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
