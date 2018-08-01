package com.revature.servlets;

import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.services.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;


public class RegistrationServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class);

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
            // already exists
            writer.println("{ \"status\": \"register failure\", \"message:\": \"User account taken\" }");
        } else {
            UserService us = new UserService();
            userPass = new UserPass(username, password);
            UserAccount user = new UserAccount(userPass, username, Date.valueOf(LocalDate.now()));
            us.saveOrUpdate(user);
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("role", "user"));
            String json = ObjectToJSONService.UserAccountToJSON(user);
            logger.info(json);
            writer.println(json);
            return;
        }
    }
}
