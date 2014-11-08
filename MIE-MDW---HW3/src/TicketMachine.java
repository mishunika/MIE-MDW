

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TicketMachine
 */
public class TicketMachine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String [] states = new String[] {"NEW", "PAYMENT", "COMPLETED"};

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketMachine() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("This app accepts only POST requests.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int state = 0;
		String persist = request.getParameter("persist");
		/**
		 * Checking what is the chosen type of persistance.
		 * Handling cookies or sessions.
		 */
		if(persist.equals("session")) {
			state = sessionHandler(request, response);
		} else if(persist.equals("cookie")) {
			state = cookieHandler(request, response);
		}

		response.getWriter().println(states[state]);
	}

	/**
	 * This method handles the request using the session persisting mode.
	 *
	 * @param request The request object redirected from the doPost method.
	 * @param response The response object redirected from the doPost method.
	 * @return the integer value of the current state.
	 */
	protected int sessionHandler(HttpServletRequest request, HttpServletResponse response) {
		Integer state;
		HttpSession session = request.getSession();
		int next = Integer.parseInt(request.getParameter("next"));

		state = (Integer)session.getAttribute("state") == null ? -1 : (Integer)session.getAttribute("state");

		if(next > 0) {
			state++;
			if(state == 2) {
				session.invalidate();
			} else {
				session.setAttribute("state", state);
			}
		}
		return state;
	}

	/**
	 * This method handles the request and persists its data to cookies. (less reliable and less secure).
	 *
	 * @param request The request object redirected from the doPost method.
	 * @param response The response object redirected from the doPost method.
	 * @return the integer value of the current state.
	 */
	protected int cookieHandler(HttpServletRequest request, HttpServletResponse response) {
		Integer state = -1;
		int next = Integer.parseInt(request.getParameter("next"));

		Cookie[] cookies = request.getCookies();

		if(cookies != null) {
			for(Cookie cookie : cookies){
			    if("state".equals(cookie.getName())){
			        state = Integer.parseInt(cookie.getValue());
			        if(state > 2)
			        	state = 0;
			    }
			}
		}

		if(next > 0) {
			state++;
			Cookie stateCookie = new Cookie("state", Integer.toString(state));
			if(state == 2) {
				stateCookie.setValue("");
				stateCookie.setMaxAge(0);
			} else {
				stateCookie.setMaxAge(60*60);
			}
			response.addCookie(stateCookie);
		}

		return state;
	}
}
