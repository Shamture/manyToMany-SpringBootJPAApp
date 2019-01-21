package com.manyToMany.SpringBootJPAApp.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studentt {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
   public Studentt(){
		
	}
	
	public Studentt(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// id
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
	
}