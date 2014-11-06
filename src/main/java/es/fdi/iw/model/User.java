package es.fdi.iw.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String id;
	
	private String role;
	
	public User() {}
	
	public User(String id, String role) {
		this.id = id;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	
	public String getRole() {
		return role;
	}
	
	public String toString() {
		return id;
	}
}
