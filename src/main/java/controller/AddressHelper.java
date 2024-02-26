package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Address;


/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */
public class AddressHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBooksJPAJoinsAttributeConv");		//creating a global instance of the Entity Manager Factory
	
	public void insertAddress(Address addressItem) {							//add an book to the database/table
		EntityManager em = emfactory.createEntityManager();			//creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(addressItem);
		em.getTransaction().commit();
		em.close();													//closes Entity Manager
	}
	
	public List<Address> showAllAddresses(){
		EntityManager em = emfactory.createEntityManager();
		List<Address> allAddresses = em.createQuery("SELECT i FROM Address i").getResultList();
		return allAddresses;		
	}
	
	
	
	
	//closing Entity Manager Factory
		public void cleanUp(){
			emfactory.close();
			}
}
