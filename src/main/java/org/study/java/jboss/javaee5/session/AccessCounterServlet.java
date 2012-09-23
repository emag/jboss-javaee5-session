package org.study.java.jboss.javaee5.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccessCounterServlet
 */
public class AccessCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static Logger logger = Logger.getLogger(AccessCounterServlet.class.getName());
	
	private static final String TITLE = "Access Counter";
	
	private static final String HEADER =
											"<html>" +
											"<head>" +
												"<title>" +
													TITLE +
												"</title>" +
											"</head>" +
											"<body>" +
											"<h1>" + TITLE + "</h1>";

	private static final String FOOTER =
											"</body>" +
											"</html>";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessCounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println(HEADER);
		
		HttpSession session = request.getSession(true);
		
		Integer counter = (Integer) session.getAttribute("yourCounter");
		
		if (counter == null) {
			counter = 0;
		}
		counter++;
		logger.info("Session ID: " + session.getId() + ", " + counter + " Times Access.");
		
		session.setAttribute("yourCounter", counter);
		
		out.println("Session ID:" + session.getId() + ", " + counter + " Times Access.");
		out.println("<a href=\"" + response.encodeURL("accesscounter") + "\">reload</a>");
		
		out.println(FOOTER);
		
		out.close();
	}

}
