package com.manyToMany.SpringBootJPAApp.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
 
//import org.json.JSONArray;
//import org.json.JSONObject;


//DataIntegrityViolationException -on delete
//--one can either use  @OnDelete(action = OnDeleteAction.CASCADE)
//or catch or throw DataIntegrityViolationException -foreign key issue.

///DataIntegrityViolationException -on create -primary key issue
//IllegalStateException -read a student - ambiguous path declaration
//DataIntegrityViolationException -update -foreign key constraint violation
//its inserting instead of updating
//MissingPathVariableException -when a path variable doesn't match the method parameter variable
//NoSuchElementException --when you pass wrong object
//NoSuchElementException -add students to subjects and remove students from subjects
//NoSuchElementException -means no object gotten matching the object passed
 //StackOverflowException -recursive call to an object.

//@JsonBackReference
@Entity
public class Subject {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "subjects")
	//@JsonIgnore
	
	
	
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonManagedReference
	private Set<Student> students;
	
    public Subject(){
    }
    
    public Subject(String name){
    	this.name = name;
    }
    
    public Subject(String name, Set<Student> students){
    	this.name = name;
    	this.students = students;
    }
	
	// name
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
	
	// students
	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	/*@Override
	public String toString(){
		String info = "";
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("name",this.name);
		JSONArray studentArray = new JSONArray();
		if(this.students != null && students.size() > 0){
			this.students.forEach(student->{
				JSONObject subJson = new JSONObject();
				subJson.put("name", student.getName());
				studentArray.put(subJson);
			});
		}
		jsonInfo.put("students", studentArray);
		info = jsonInfo.toString();
		return info;
	}
	*/
}
