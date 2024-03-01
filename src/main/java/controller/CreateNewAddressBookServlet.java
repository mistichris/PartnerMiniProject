package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ListDetailsHelper;
import helpers.ContactItemsHelper;
import model.ListDetails;
import model.ContactItems;
import model.ListOwner;

/**
 * Servlet implementation class CreateNewAddressListServlet
 */
@WebServlet("/createNewAddressBookServlet")
public class CreateNewAddressBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateNewAddressBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactItemsHelper cih = new ContactItemsHelper();
		String listName = request.getParameter("addressBookName");
		System.out.println("List Name: " + listName);
		
		String ownerName = request.getParameter("listOwner");
				
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<ContactItems> selectedItemsInList = new ArrayList<ContactItems>();
		// make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ContactItems c = cih.searchForContactItemsById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		ListOwner ListOwner = new ListOwner(ownerName);
		ListDetails cld = new ListDetails(listName, ListOwner);
		cld.setListOfContacts(selectedItemsInList);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(cld);
		
		System.out.println("Success!");
		System.out.println(cld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllAddressBooksServlet").forward(request, response);
  	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
