package com.manyToMany.SpringBootJPAApp.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subjectt {

	
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	
	
    public Subjectt(){
    }
    
    public Subjectt(String name){
    	this.name = name;
    }
    
   
	
	// name
	public String getName() {
		return name;
		
	}
	public void setName(String name) {
		this.name = name;
		
	}
	
	public int getId() {
		return id;
		
	}
	public void setId(int id) {
		this.id = id;
		
	}
}
