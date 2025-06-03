package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    // LoginServlet should:
    //  check session attribute "user".
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //for GET request
        // if the session attribute "user" does not exist,
        //  redirect to the /login.jsp page
        //  else redirect to the /user/hello.jsp.,
//        String redirUrl = (req.getSession(false) != null
//                && req.getSession(false).getAttribute("user") != null)
//                ? "/user/hello.jsp" : "/login.jsp";
//        resp.sendRedirect(redirUrl);

        if ((req.getSession(false) != null
                && req.getSession(false).getAttribute("user") != null)) {
            res.sendRedirect("/user/hello.jsp");
        } else
            req.getRequestDispatcher("/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //for POST request
        // check the request parameters:
        String un = req.getParameter("login");
        String pw = req.getParameter("password");
        //  "login" value should exist in Users and
        boolean loginValExists = Users.getInstance().getUsers()
                .stream().filter(Objects::nonNull).anyMatch(v -> v.equals(un));
        //  the request parameter "password" shouldn't be empty.
        boolean passValExistsAndNotEmpty = pw != null && !pw.trim().isBlank();

        // If parameters are correct
        if (loginValExists && passValExistsAndNotEmpty) {
            //  set session attribute "user" and
            req.getSession().setAttribute("user", un);
            //  redirect to /user/hello.jsp,
            res.sendRedirect(req.getContextPath() + "/user/hello.jsp");
        } else {
            //  else - forward to the /login.jsp.
            req.setAttribute("error", "Invalid creds!");
            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
    }
}
