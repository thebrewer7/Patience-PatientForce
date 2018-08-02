package com.revature.servlets;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.services.*;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class);

    private static final String invalidCredentials = "{ \"status\": \"failure\", \"message:\": \"Username and Password combination is invalid\" }";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.info("Login: Username: " + username + " Password: " + password);

        UserPassService ups = new UserPassService();
        UserPass up = ups.getByUsername(username);

        response.setContentType("text/json");
        PrintWriter writer = response.getWriter();

        if (up != null && up.getPassword().equals(password)) {
            logger.info("UserPass: Username: " + up.getUsername() + " Password: " + up.getPassword() + "UserID: " + up.getId());
            int userId = up.getId();
            String role = up.getRole();

            String json = "";

            switch (role) {
                case "user":
                    UserService us = new UserService();
                    UserAccount user = us.getByUserPass(userId);
                    logger.info(user);
                    if (user != null) {
                        json = ObjectToJSONService.UserAccountToJSON(user);
                    }
                    break;

                case "patient":
                    PatientService ps = new PatientService();
                    Patient patient = ps.getByUserPass(userId);
                    logger.info(patient);
                    if (patient != null) {
                        json = ObjectToJSONService.PatientToJSON(patient);
                    }
                    break;

                case "nurse":
                    NurseService ns = new NurseService();
                    Nurse nurse = ns.getByUserPass(userId);
                    logger.info(nurse);
                    if (nurse != null) {
                        json = ObjectToJSONService.NurseToJSON(nurse);
                    }
                    break;

                case "doctor":
                    DoctorService ds = new DoctorService();
                    Doctor doctor = ds.getByUserPass(userId);
                    logger.info(doctor);
                    if (doctor != null) {

                        json = ObjectToJSONService.DoctorToJSON(doctor);
                    }
                    break;

            }
            if (!json.equals("")) {
                response.addCookie(new Cookie("username", username));
                response.addCookie(new Cookie("role", up.getRole()));
                logger.info(json);
                writer.println(json);
            }

        } else {
            writer.println(invalidCredentials);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
