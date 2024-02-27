package testers;

import java.util.List;

import helpers.ListAddressHelper;
import model.ListAddress;

/**
 * @author Misti Christianson - mchristianson CIS175 - Spring 2024 Feb 27, 2024
 */
public class AddContactTester {

	public static void main(String[] args) {
		ListAddressHelper lah = new ListAddressHelper();

		ListAddress harry = new ListAddress("Harry", "Potter", "515-555-1234");
		lah.insertAddress(harry);
		
		ListAddress rick = new ListAddress("Rick", "Sanchez", "515-555-4567", "rick@citadel.org");
		lah.insertAddress(rick);
		
		ListAddress morty = new ListAddress("Morty", "Smith", "515-555-5678", "morty@gmail.com");
		lah.insertAddress(morty);
		
		List<ListAddress> allListAddress = lah.showAllAddresses();
		for(ListAddress a: allListAddress) {
			System.out.println(a.toString());
		}
	}

}
