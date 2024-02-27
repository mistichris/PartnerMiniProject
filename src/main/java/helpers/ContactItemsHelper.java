package helpers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ContactItems;

/**
 * Larry Paucar - Lpaucar CIS175 -Spring 2024 Feb 26, 2024
 */
public class ContactItemsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerMiniProject"); // creating a global instance of the entity Manager Factory

	public void insertAddress(ContactItems contactItem) { // add an book to the database/table
		EntityManager em = emfactory.createEntityManager(); // creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(contactItem);
		em.getTransaction().commit();
		em.close(); // closes Entity Manager
	}

	@SuppressWarnings("unchecked")
	public List<ContactItems> showAllContacts() {
		EntityManager em = emfactory.createEntityManager();
		List<ContactItems> allContacts = em.createQuery("SELECT i FROM ContactItems i").getResultList();
		return allContacts;
	}
	
	/**
	 * @param toDelete
	 */
	public void deleteItem(ContactItems toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactItems> typedQuery = em.createQuery("select a from ContactItems a where a.firstName = :selectedFirstName and a.streetAddress = :selectedStreetAddress",
				ContactItems.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
		typedQuery.setParameter("selectedStreetAddress", toDelete.getStreetAddress());
		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		ContactItems result = typedQuery.getSingleResult();
		// remove it 
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public ContactItems searchForContactItemsById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ContactItems found = em.find(ContactItems.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param firstName
	 * @return
	 */
	public List<ContactItems> searchForContactItemsByFirstName(String firstName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactItems> typedQuery = em
				.createQuery("select a from ContactItems a where a.firstName = :selectedFirstName", ContactItems.class);
		typedQuery.setParameter("selectedFirstName", firstName);
		List<ContactItems> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param state
	 * @return
	 */
	public List<ContactItems> searchForContactItemsByState(String state) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactItems> typedQuery = em.createQuery("select a from ContactItems a where a.state = :selectedState",
				ContactItems.class);
		typedQuery.setParameter("selectedState", state);
		List<ContactItems> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(ContactItems toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	// closing Entity Manager Factory
	public void cleanUp() {
		emfactory.close();
	}
}
