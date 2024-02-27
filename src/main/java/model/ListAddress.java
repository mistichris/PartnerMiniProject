package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Feb 26, 2024
 */
@Entity // creates a new table
@Table(name = "addresslist") // names the table
public class ListAddress {
	@Id // Marks as primary key field
	@GeneratedValue // Auto generates the primary key in the database
	@Column(name = "ID") // Column Heading Name
	private int id; // field variable
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="STREETADDRESS")
	private String streetAddress;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="ZIP")
	private String zip;
	@Column(name="PHONE")
	private String phone;
	@Column(name="EMAIL")
	private String email;
	
	//Default constructor
	public ListAddress() {
		super();
	}
	
	//Constructor with all fields
	public ListAddress(String firstName, String lastName, String streetAddress, String city, String state,
			String zip, String phone, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}
	
	//Constructor with name, email and phone only
	public ListAddress(String firstName, String lastName, String phone, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
	
	//Constructor with name and phone only
	public ListAddress(String firstName, String lastName, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	
	//Getters and setters
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Address [firstName=" + firstName + ", lastName=" + lastName + ", streetAddress=" + streetAddress
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email
				+ "]";
	}


	
	

}