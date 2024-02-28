package testers;

import java.util.ArrayList;
import java.util.List;

import helpers.ListDetailsHelper;
import helpers.ListOwnerHelper;
import model.ContactItems;
import model.ListDetails;
import model.ListOwner;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 27, 2024
 */
public class AddListDetailsTester {

	public static void main(String[] args) {
		ListOwner summer = new ListOwner("Summer Smith");
//		ListOwnerHelper loh = new ListOwnerHelper();
//		loh.insertListOwner(summer);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ContactItems jerry = new ContactItems("Jerry", "Smith");
		ContactItems beth = new ContactItems("Beth", "Smith");
		
		List<ContactItems> summersContacts = new ArrayList<ContactItems>();
		summersContacts.add(jerry);
		summersContacts.add(beth);
		
		 ListDetails summerAddressBook = new ListDetails("Summer's AddressBook", summer);
		 summerAddressBook.setListOfContacts(summersContacts);
		 
		 ldh.insertNewListDetails(summerAddressBook);
		 
		 List<ListDetails> allLists = ldh.getLists();
		 
		 for(ListDetails a: allLists) {
			 System.out.println(a.toString());
		 }
		 
		 
	}

}
