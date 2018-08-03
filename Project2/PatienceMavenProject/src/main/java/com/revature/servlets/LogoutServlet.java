package com.revature.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LogoutServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //this.getServletContext().setAttribute("userpassid", 0);
        logger.info("User logging out");
//        System.out.println(request.getCookies());
//        Cookie[] cookies  = request.getCookies();
//        for (Cookie cookie : cookies) {
//            logger.info("Removing cookie: " + cookie.getName());
//            cookie.setMaxAge(0);
//            response.addCookie(cookie);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
