package testers;

import java.util.List;

import helpers.ContactItemsHelper;
import model.ContactItems;

/**
 * @author Misti Christianson - mchristianson CIS175 - Spring 2024 Feb 27, 2024
 */
public class AddContactTester {

	public static void main(String[] args) {
		ContactItemsHelper lah = new ContactItemsHelper();

		ContactItems harry = new ContactItems("Harry", "Potter", "515-555-1234");
		lah.insertAddress(harry);
		
		ContactItems rick = new ContactItems("Rick", "Sanchez", "515-555-4567", "rick@citadel.org");
		lah.insertAddress(rick);
		
		ContactItems morty = new ContactItems("Morty", "Smith", "515-555-5678", "morty@gmail.com");
		lah.insertAddress(morty);
		
		List<ContactItems> allListAddress = lah.showAllAddresses();
		for(ContactItems a: allListAddress) {
			System.out.println(a.toString());
		}
	}

}
