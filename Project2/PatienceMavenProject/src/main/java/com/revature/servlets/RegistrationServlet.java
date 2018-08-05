package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.services.ObjectToJSONService;
import com.revature.services.UserPassService;
import com.revature.services.UserService;

public class RegistrationServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(RegistrationServlet.class);
    private static final String usernameTakerError = "{ \"status\": \"failure\", \"message:\": \"User account taken\" }";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.info("Registration: Username: " + username + " Password: " + password);

        UserPassService ups = new UserPassService();
        UserPass up = ups.getByUsername(username);

        response.setContentType("text/json");
        PrintWriter writer = response.getWriter();

        UserPass userPass = ups.getByUsername(username);

        if (userPass != null) {
            writer.println(usernameTakerError);
        } else {
            UserService us = new UserService();
            userPass = new UserPass(username, password, "user");
            ups.saveOrUpdate(userPass);
            UserAccount user = new UserAccount(userPass, username, Date.valueOf(LocalDate.now()));
            us.saveOrUpdate(user);
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("role", "user"));
            String json = ObjectToJSONService.UserAccountToJSON(user);
            logger.info("registrationservlet returned a useraccount");
            writer.println(json);
        }
    }
}
