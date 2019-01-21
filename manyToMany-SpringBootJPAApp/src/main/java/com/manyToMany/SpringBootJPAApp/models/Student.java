package com.manyToMany.SpringBootJPAApp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
 
//import org.json.JSONArray;
//import org.json.JSONObject;
 
@Entity
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
	
	//@JsonIgnore
	  //all references of Subject will have Student object with them
	@Column(nullable =true)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference
	private Set<Subject> subjects= new HashSet<>();;
	
	public Student(){
		
	}
	
	public Student(String name){
		this.name = name;
	}
	
	public Student(String name, Set<Subject> subjects){
		this.name = name;
		this.subjects = subjects;
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
		
	
	// subjects
	public Set<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	/*@Override
	public String toString(){
		String info = "";
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("name",this.name);
		JSONArray subArray = new JSONArray();
		this.subjects.forEach(sub->{
			JSONObject subJson = new JSONObject();
			subJson.put("name", sub.getName());
			subArray.put(subJson);
		});
		jsonInfo.put("subjects", subArray);
		info = jsonInfo.toString();
		return info;
	}*/
}
