package testers;

import java.util.List;

import helpers.ListOwnerHelper;
import model.ListOwner;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 27, 2024
 */
public class AddListOwnerTester {

	public static void main(String[] args) {
		ListOwnerHelper  lo = new ListOwnerHelper();
		
		ListOwner harry = new ListOwner("Harry");
		lo.insertListOwner(harry);
		
		ListOwner jerry = new ListOwner("Jerry");
		lo.insertListOwner(jerry);
		
		List<ListOwner> allListOwners = lo.showAllOwners();
		for (ListOwner a: allListOwners) {
			System.out.println(a.toString());
		}
	}

}
