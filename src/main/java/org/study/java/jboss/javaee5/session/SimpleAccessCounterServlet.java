package org.study.java.jboss.javaee5.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * Servlet implementation class AccessCounterServlet
 */
public class SimpleAccessCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger(SimpleAccessCounterServlet.class.getName());

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);

        Integer counter = (Integer) session.getAttribute("yourCounter");

        if (counter == null) {
            counter = 0;
        }
        counter++;
        logger.info("Session ID: " + session.getId() + ", " + counter + " Times Access.");

        session.setAttribute("yourCounter", counter);

        out.println("Session ID:" + session.getId() + ", " + counter + " Times Access.");

        out.close();

    }

}
