package com.esprit.microservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;



@Entity
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private String email;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setEmail(String email) {
		this.email = email;}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public String getEmail() {
		return email;
	}
	public Supplier(int id, String name, String location, String email) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.email = email;
	}
	public Supplier(String name, String location, String email) {
		super();
		this.name = name;
		this.location = location;
		this.email = email;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    // Getters and setters
}
