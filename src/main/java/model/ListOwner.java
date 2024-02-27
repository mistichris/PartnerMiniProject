package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Misti Christianson - mchristianson CIS175 - Spring 2024 Feb 27, 2024
 */
@Entity
public class ListOwner {
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;

	public ListOwner() {
		super();
	}

	public ListOwner(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "ListOwner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
