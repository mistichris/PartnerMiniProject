package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ListDetailsHelper;
import helpers.ContactItemsHelper;
import helpers.ListOwnerHelper;
import model.ListDetails;
import model.ContactItems;
import model.ListOwner;

/**
 * Servlet implementation class EditAddressBookServlet
 */
@WebServlet("/EditAddressBookServlet")
public class EditAddressBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditAddressBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDetailsHelper dao = new ListDetailsHelper();

		ContactItemsHelper cih = new ContactItemsHelper();
		ListOwnerHelper loh= new ListOwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
//		String year = request.getParameter("year");
		
		String listOwner = request.getParameter("listOwner");

		// find our add the new ListOwner
		ListOwner newOwner = loh.findOwner(listOwner);
//		LocalDate ld;
//		try {
//			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
//		} catch (NumberFormatException ex) {
//			ld = LocalDate.now();
//		}
		try { // items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ContactItems> selectedItemsInList = new ArrayList<ContactItems>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ContactItems c = cih.searchForContactItemsById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfContacts(selectedItemsInList);
		} catch (NullPointerException ex) { // no items selected in list - set to an empty list
			List<ContactItems> selectedItemsInList = new ArrayList<ContactItems>();
			listToUpdate.setListOfContacts(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
//		listToUpdate.setTripDate(ld);
		listToUpdate.setOwner(newOwner);
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAddressBooksServlet").forward(request, response);

	}

}
