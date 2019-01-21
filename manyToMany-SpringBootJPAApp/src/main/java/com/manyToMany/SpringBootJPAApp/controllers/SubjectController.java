package com.manyToMany.SpringBootJPAApp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manyToMany.SpringBootJPAApp.models.Student;
import com.manyToMany.SpringBootJPAApp.models.Subject;
import com.manyToMany.SpringBootJPAApp.repository.StudentRepository;
import com.manyToMany.SpringBootJPAApp.repository.SubjectRepository;

@RestController
@RequestMapping("/api")
public class SubjectController {
	
	@Autowired
	SubjectRepository subjectrepo;
	
	//Create a new Subject
	@PostMapping("/subject")
	public void createSubject(Subject subject) {
		
		subjectrepo.save(subject);
	}
	
	//Get a list of Subjects
	@GetMapping("/subjects")
	public List<Subject> getSubjects(){
		List<Subject> subjectslist =subjectrepo.findAll();
		
		return subjectslist;
		
	}
	
	//Get a Subject by id
	
	@GetMapping("/subjects/{subjectId}")
	public Optional<Subject> getSubject(@PathVariable(name="subjectId") int subjectid) {
		
		Optional<Subject> asubject =subjectrepo.findById(subjectid);
		
		return asubject;
	}
	
	//Update a Subject by id
	@PutMapping("/subjects/{subjectId}")
	public void updateSubject(@RequestBody Subject asubject,@PathVariable(name="subjectId") int subjectid) {
	 Optional<Subject> sub =	subjectrepo.findById(subjectid);
	 
	 if(sub != null) {
		 subjectrepo.save(asubject) ;
	 }
	}
	
	//Delete a Subject by id
	@DeleteMapping("/subjects/{subjectId}")
	public void deleteSubject(@PathVariable(name="subjectId") int subjectid) {
		subjectrepo.deleteById(subjectid);
	}
	
	
	
	

}
