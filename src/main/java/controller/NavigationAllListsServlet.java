package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ContactItemsHelper;
import helpers.ListDetailsHelper;
import model.ListDetails;

/**
 * Servlet implementation class NavigationAllListsServlet
 */
@WebServlet("/navigationAllListsServlet")
public class NavigationAllListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NavigationAllListsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContactItemsHelper daoForItems = new ContactItemsHelper();
		ListDetailsHelper daoListDetails = new ListDetailsHelper();
		request.setAttribute("allItems", daoForItems.showAllContacts());
		String act = request.getParameter("doThisToList");
		if (act == null) { // no button has been selected
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

		} else if (act.equals("Delete An Address Book")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = daoListDetails.searchForListDetailsById(tempId);
				daoListDetails.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllAddressBooksServlet").forward(request, response);
			}
		} else if (act.equals("Edit An Address Book")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = daoListDetails.searchForListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
//				ContactItemsHelper daoForItems = new ContactItemsHelper();
//				request.setAttribute("allItems", daoForItems.showAllItems());
				if (daoForItems.showAllContacts().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/edit-adressbook.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllAddressBooksServlet").forward(request, response);
			}
		} else if (act.equals("Add An Address Book")) {
			getServletContext().getRequestDispatcher("/new-addressbook.jsp").forward(request, response);
		}
	}
}
