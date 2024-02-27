package helpers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ContactItems;


/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Feb 26, 2024
 */
public class ContactItemsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerMiniProject");		//creating a global instance of the Entity Manager Factory
	
	
	public void insertAddress(ContactItems contactItem) {							//add an book to the database/table
		EntityManager em = emfactory.createEntityManager();			//creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(contactItem);
		em.getTransaction().commit();
		em.close();													//closes Entity Manager
	}
	
	@SuppressWarnings("unchecked")
	public List<ContactItems> showAllAddresses(){
		EntityManager em = emfactory.createEntityManager();
		List<ContactItems> allAddresses = em.createQuery("SELECT i FROM ContactItems i").getResultList();
		return allAddresses;		
	}
	
	
	
	
	
	//closing Entity Manager Factory
		public void cleanUp(){
			emfactory.close();
			}
}
