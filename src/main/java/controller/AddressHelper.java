package controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;



/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */
public class AddressHelper {
	
	static EntityManagerFactory emfactory = 


	 public List<Address> showAllItems(){
		 EntityManager em = emfactory.createEntityManager();
		 List<Address> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		 return allItems; 
		 }
	

		/**
		 * @param toDelete
		 */
		public void deleteItem(Address toDelete) {
			// TODO Auto-generated method stub
			 EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
			 TypedQuery<Address> typedQuery = em.createQuery("select a from Address a where a.firstName = :selectedFirstName and a.streetAddress = :selectedStreetAddress", Address.class);

			//Substitute parameter with actual data from the toDelete item 
			 typedQuery.setParameter("selectedFirstName", toDelete.getFirstName()); typedQuery.setParameter("selectedStreetAddress", toDelete.getStreetAddress());
			//we only want one result 
			 typedQuery.setMaxResults(1);
			//get the result and save it into a new list item
			 Address result = typedQuery.getSingleResult();
			//remove it em.remove(result); 
			 em.getTransaction().commit(); em.close();

		 }

		/**
		 * @param idToEdit
		 * @return
		 */
		public Address searchForAddressById(int idToEdit) {
			EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
			Address found = em.find(Address.class, idToEdit); em.close();
			return found;
		}

		/**
		 * @param firstName
		 * @return
		 */
		public List<Address> searchForAddressByFirstName(String firstName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
			TypedQuery<Address> typedQuery = em.createQuery("select a from Address a where a.firstName = :selectedFirstName", Address.class); typedQuery.setParameter("selectedFirstName", firstName);
			List<Address> foundItems = typedQuery.getResultList(); em.close();
			return foundItems;	
		}

		/**
		 * @param state
		 * @return
		 */
		public List<Address> searchForAddressByState(String state) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
			TypedQuery<Address> typedQuery = em.createQuery("select a from Address a where a.state = :selectedState", Address.class); typedQuery.setParameter("selectedState", state);
			List<Address> foundItems = typedQuery.getResultList(); em.close();
			return foundItems;
		}


		/**
		 * @param toEdit
		 */
		public void updateItem(Address toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager(); 
			em.getTransaction().begin();
			em.merge(toEdit); 
			em.getTransaction().commit(); 
			em.close();
			
		}


		//closing Entity Manager Factory
		public void cleanUp(){
			emfactory.close();
			
	}

	
	
}
