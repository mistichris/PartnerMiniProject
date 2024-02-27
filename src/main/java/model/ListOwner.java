package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 27, 2024
 */
@Entity
public class ListOwner {
@Id
@GeneratedValue
private int id;
private String firstName;
private String lastName;

 
}
