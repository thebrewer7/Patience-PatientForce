package com.revature.servlets;

import com.revature.beans.UserPass;
import com.revature.services.UserPassService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

            String json = "{ \"userpassid\": \"" + userId +  "\", \"role\": \"" + role + "\" }";
            logger.info(json);
            writer.println(json);

        } else {
            writer.println(invalidCredentials);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
