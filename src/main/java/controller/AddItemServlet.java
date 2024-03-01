package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ContactItemsHelper;
import model.ContactItems;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public AddItemServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		//removed this line of script -- prevents from entering a contact with missing information
//		 if (firstName.isEmpty() || lastName.isEmpty() || streetAddress.isEmpty() || city.isEmpty() || state.isEmpty() || zip.isEmpty() || phone.isEmpty() || email.isEmpty() || firstName == null || lastName == null
//				 || streetAddress == null || city == null || state == null || zip == null || phone == null || phone == null || email == null) {
//	            // Redirect to index.html if any parameter is empty
//	            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
//	        } else {
	        	
	     ContactItems ContactItems = new ContactItems(firstName, lastName, streetAddress, city, state, zip, phone, email);
	     ContactItemsHelper dao = new ContactItemsHelper();
	     dao.insertAddress(ContactItems);
	             
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
//	}

}
