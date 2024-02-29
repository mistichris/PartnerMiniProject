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

<<<<<<< HEAD
import helpers.ListDetailsHelper;
import helpers.ContactItemsHelper;
import model.ListDetails;
import model.ContactItems;
import model.ListOwner;

=======
import helpers.ContactItemsHelper;
import helpers.ListDetailsHelper;
import model.ContactItems;
import model.ListDetails;
import model.ListOwner;

//Larry

>>>>>>> 4f3ca5c (initial commit)
/**
 * Servlet implementation class CreateNewAddressListServlet
 */
@WebServlet("/createNewAddressListServlet")
public class CreateNewAddressBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateNewAddressBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		ContactItemsHelper cih = new ContactItemsHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String ownerName = request.getParameter("ownerName");
				
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
=======
        ContactItemsHelper lih = new ContactItemsHelper();
        String listName = request.getParameter("listName");
        System.out.println("List Name: "+ listName);
        
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String year = request.getParameter("year");
        String listOwner =  request.getParameter("listOwnerName");
        LocalDate ld;
        try {
             ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        }catch(NumberFormatException ex) {
             ld = LocalDate.now();
        }
        
        String[] selectedItems = request.getParameterValues("allItemsToAdd");
        	List<ContactItems> selectedItemsInList = new ArrayList<ContactItems>();
        		if (selectedItems != null && selectedItems.length > 0)
        		{
        		for(int i = 0; i<selectedItems.length; i++) {
        		     System.out.println(selectedItems[i]);
        		     ContactItems c = lih.searchForContactItemsById(Integer.parseInt(selectedItems[i]));
        		               selectedItemsInList.add(c);
        		} }
        		     ListOwner owner = new ListOwner(listOwner);
        		     ListDetails sld = new ListDetails(listName, ld, owner);
        		     
        		     sld.setListOfContacts(selectedItemsInList);
        		     ListDetailsHelper slh = new ListDetailsHelper();
        		     slh.insertNewListDetails(sld);
        		          
        		     System.out.println("Success!");
        		     System.out.println(sld.toString());
        		     getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
        
>>>>>>> 4f3ca5c (initial commit)
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
