package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {
    //ContextListener should:
    //
    // set "servletTimeInit" attribute in the context,
    // as a LocalDateTime object, showing when the context was initialized.
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("servletTimeInit", LocalDateTime.now());
    }
}
