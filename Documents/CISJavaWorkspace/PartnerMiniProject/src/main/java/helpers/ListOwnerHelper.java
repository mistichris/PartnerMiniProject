package helpers;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.NoResultException;

import model.ListOwner;

/**
 * @author Misti Christianson - mchristianson CIS175 - Spring 2024 Feb 27, 2024
 */
public class ListOwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerMiniProject");

	public void insertListOwner(ListOwner owner) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(owner);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<ListOwner> showAllOwners() {
		EntityManager em = emfactory.createEntityManager();
		List<ListOwner> allOwners = em.createQuery("SELECT owner FROM ListOwner owner").getResultList();
		return allOwners;
	}

	public ListOwner findOwner(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOwner> typedQuery = em.createQuery("SELECT lo FROM ListOwner WHERE lo.listOwnerName = :selectedName", ListOwner.class);
				typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		ListOwner foundOwner;
		try {
			foundOwner = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundOwner = new ListOwner(nameToLookUp);
		}
		em.close();		
		return foundOwner;
	}

	// delete an owner from the database
	@SuppressWarnings("unused")
	public void deleteBook(ListOwner toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOwner> typedQuery = em.createQuery("Select lo from ListOwner lo where lo.id = :selectedId",
				ListOwner.class);
		typedQuery.setParameter("selectedId", toDelete.getId());

		// we only want on result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list book
		ListOwner result = typedQuery.getSingleResult(); // creating a ListBook object for the results

		// remove it
		em.remove(result); // removing result/book from table in database
		em.getTransaction().commit();
		em.close(); // closing the Entity Manager
	}

	// update an owner in database script
	public void updateOwner(ListOwner toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit); // merging edits with current item in database using toEdit object
		em.getTransaction().commit();
		em.close(); // closing the Entity Manager
	}

	// search for owner by name script
	public List<ListOwner> searchForOwnerByName(String listOwnerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// returns an object of a given parameter to a new list titled 'typedQuery'
		TypedQuery<ListOwner> typedQuery = em.createQuery("select lo from ListOwner li where lo.owner = :selectedOwner",
				ListOwner.class);
		typedQuery.setParameter("selectedOwner", listOwnerName);
		List<ListOwner> foundOwner = typedQuery.getResultList();
		em.close();
		return foundOwner;
	}

	// Search for Owner by ID script
	public ListOwner searchForBookById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListOwner found = em.find(ListOwner.class, idToEdit);
		em.close();
		return found;
	}

	public void close() {
		emfactory.close();
	}

}
