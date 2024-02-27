package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 27, 2024
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate createdDate;
	private ListOwner owner;
	private List<ContactItems> listOfContacts;
	
	//ToDo	Create relationships with ListOwner -- but which ones
	//@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER) 
	//@ManyToOne(cascade=CascadeType.PERSIST)
	
	
	//empty constructor
	public ListDetails() {
		super();
	}
	
	//constructor with parameters
	public ListDetails(String listName, ListOwner owner, List<ContactItems> listOfContacts) {
		super();
		this.listName = listName;
		this.owner = owner;
		this.listOfContacts = listOfContacts;
		setCreatedDate(LocalDate.now());
		
	}

	//Getters and Setters minus ID field
	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		createdDate =  LocalDate.now();
	}

	public ListOwner getOwner() {
		return owner;
	}

	public void setOwner(ListOwner owner) {
		this.owner = owner;
	}

	public List<ContactItems> getListOfContacts() {
		return listOfContacts;
	}

	public void setListOfContacts(List<ContactItems> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}
}
