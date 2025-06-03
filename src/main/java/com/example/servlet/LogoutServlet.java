package com.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    //LogoutServlet should:
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        var session = req.getSession();
//                req.getSession(false);

//        if (session != null) {
            session.removeAttribute("user");
            session.invalidate();
//        }

        res.sendRedirect(req.getContextPath() + "/login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        var session = req.getSession();

//        if (session != null) {
            //delete session attribute "user".
            session.removeAttribute("user");
            // invalidate session.
            session.invalidate();
//        }
        //redirect to /login.jsp
        res.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
