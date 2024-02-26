package model;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Feb 26, 2024
 */
public class ListAddress {
	
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	
	//Default constructor
	public ListAddress() {
		super();
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

	//Constructor using parameters
	public ListAddress(String firstName, String lastName, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
	}
	
	

}