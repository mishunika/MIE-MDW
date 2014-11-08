package contact;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactDBManager
 */
public class ContactDBManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ContactDB contacts = new ContactDB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactDBManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		response.setContentType("text/html");
		if(action == null) {
			request.setAttribute("contacts", contacts.getContacts());
		    request.getRequestDispatcher("/ListContacts.jsp").forward(request, response);
		} else if (action.equals("createContact")) {
		    request.getRequestDispatcher("/CreateContact.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("addContact")) {
			Contact contact = new Contact();
			contact.setName(request.getParameter("name"));
			contact.setMail(request.getParameter("mail"));
			contacts.addContact(contact);
		} else if(action.equals("removeContact")) {
			contacts.removeContact(request.getParameter("name"), request.getParameter("mail"));
		}
		response.sendRedirect("ContactDBManager");
	}

}
