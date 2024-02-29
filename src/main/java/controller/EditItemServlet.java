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
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //Larry will do
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactItemsHelper dao = new ContactItemsHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ContactItems itemToUpdate = dao.searchForContactItemsById(tempId);
				
		itemToUpdate.setFirstName(firstName);
		itemToUpdate.setLastName(lastName);
		itemToUpdate.setStreetAddress(streetAddress);
		itemToUpdate.setCity(city);
		itemToUpdate.setState(state);
		itemToUpdate.setZip(zip);
		itemToUpdate.setPhone(phone);
		itemToUpdate.setEmail(email);
		
		dao.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);

	}

}
