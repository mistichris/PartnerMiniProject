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
	private String listOwnerName;

	public ListOwner() {
		super();
	}

	public ListOwner(String listOwnerName) {
		super();
		this.listOwnerName = listOwnerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getlistOwnerName() {
		return listOwnerName;
	}

	public void setlistOwnerName(String listOwnerName) {
		this.listOwnerName = listOwnerName;
	}

	@Override
	public String toString() {
		return listOwnerName;
	}

}
