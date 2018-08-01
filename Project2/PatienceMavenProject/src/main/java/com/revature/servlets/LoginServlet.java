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
import java.util.List;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.info("Login: Username: " + username + " Password: " + password);

        UserPassService ups = new UserPassService();
        UserPass up = ups.getByUsername(username);

        response.setContentType("text/json");
        PrintWriter writer = response.getWriter();

        if (up.getPassword().equals(password)) {
            String json = "";

            response.addCookie(new Cookie("username", username));

            UserService us = new UserService();
            List<UserAccount> users = us.getByName(username);
            if (users.size() > 0) {
                UserAccount user = users.get(0);
                response.addCookie(new Cookie("role", "user"));
                json = ObjectToJSONService.UserAccountToJSON(user);
                logger.info(json);
                writer.println(json);
                return;
            }

            PatientService ps = new PatientService();
            List<Patient> patients = ps.getByName(username);
            if (patients.size() > 0) {
                Patient patient = patients.get(0);
                response.addCookie(new Cookie("role", "patient"));
                json = ObjectToJSONService.PatientToJSON(patient);
                logger.info(json);
                writer.println(json);
                return;
            }

            NurseService ns = new NurseService();
            List<Nurse> nurses = ns.getByName(username);
            if (nurses.size() > 0) {
                Nurse nurse = nurses.get(0);
                response.addCookie(new Cookie("role", "nurse"));
                json = ObjectToJSONService.NurseToJSON(nurse);
                logger.info(json);
                writer.println(json);
                return;
            }

            DoctorService ds = new DoctorService();
            List<Doctor> doctors = ds.getByName(username);
            if (doctors.size() > 0) {
                Doctor doctor = doctors.get(0);
                response.addCookie(new Cookie("role", "doctor"));
                json = ObjectToJSONService.DoctorToJSON(doctor);
                logger.info(json);
                writer.println(json);
                return;
            }
        } else {
            writer.println("{ \"status\": \"login failure\", \"message:\": \"invalid credentials\" }");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
