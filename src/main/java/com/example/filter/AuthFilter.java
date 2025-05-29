package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/users/*")

public class AuthFilter implements Filter {
    //AuthFilter should:
    //
    // check session attribute "user" for paths /user/*.
    // If there isn't,
    //  redirect the request to the /login.jsp page.

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("name") != null)
            chain.doFilter(request, response);
        else
            res.sendRedirect("/login.jsp");
    }

    @Override
    public void destroy() {
    }
}