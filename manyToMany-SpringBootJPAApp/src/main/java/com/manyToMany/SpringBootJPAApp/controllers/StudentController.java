package com.manyToMany.SpringBootJPAApp.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import com.manyToMany.SpringBootJPAApp.models.Student;
import com.manyToMany.SpringBootJPAApp.repository.StudentRepository;
import com.manyToMany.SpringBootJPAApp.models.Subject;
import com.manyToMany.SpringBootJPAApp.repository.SubjectRepository;

//import com.manyToMany.SpringBootJPAApp.pojos.Student;
import com.manyToMany.SpringBootJPAApp.repository.StudentObjRepository;
import com.manyToMany.SpringBootJPAApp.pojos.Subjectt;
import com.manyToMany.SpringBootJPAApp.repository.SubjectObjRepository;


@RestController
//@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentRepository studentrepo;
	
	@Autowired
	SubjectRepository subjectrepo;
	
	@Autowired
	StudentObjRepository stdrepo;
	
	@Autowired
	SubjectObjRepository subrepo;
	
	//create a new student
	@PostMapping("/student")
	public void createStudent(Student student) {
		studentrepo.save(student);
	}
	
	//Get All Students
	@GetMapping("/students/")
	public List<Student> fetchStudents( ){
	List<Student> studentlist =studentrepo.findAll();
	return studentlist;
	}
	/*public ResponseEntity<List<Student>> getStudents() {
		return new ResponseEntity<List<Student>>((List<Student>) studentrepo.findAll(), HttpStatus.OK);
	}
	
	
	}*/
	
	
	//Get a Student by Id
	@GetMapping("/student/{studentId}")
	public Optional<Student> getStudent(@PathVariable(name="studentId") int studentId) {
		Optional<Student> astudent =studentrepo.findById(studentId);
		
		return astudent;
	}
	/*public ResponseEntity<Student> getStudent(@PathVariable long id) {
		
		if (studentrepo.findOne(id) != null) {
			return new ResponseEntity<Student>(studentrepo.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	}*/
	
	//Update a Student by Id
	
	@PutMapping("/students/{studentId}")
	public void updateStudent(@RequestBody Student astudent,@PathVariable(name="studentId") int studentId) {
		Optional<Student> std =studentrepo.findById(studentId);
		 if(std != null){
			 studentrepo.save(astudent); 
			 
		 }
	}
	
	//Delete a Student by Id
	
	@DeleteMapping("/students/{studentId}")
	public void deletStudent(@PathVariable(name="studentId") int studentId) {
		studentrepo.deleteById(studentId);
	}
	
	
	//Method to add a new student to a subject.
	@PostMapping("/{subjectid}/students/{studentId}") // Path variable names must match with method's signature variables.
    public Set<Student> addStudentToSubject(@PathVariable int subjectid, @PathVariable int studentId){
       
		// Finds a persisted student
        Optional<Student> student = this.studentrepo.findById(studentId);//.orElseThrow(
               // () -> new ResourceNotFoundException("Student", studentId)
       // );
        
        // Finds a subject and adds the given student to the subject's set.
        Optional<Subject> subject = this.subjectrepo.findById(subjectid);//.orElseThrow(
        // () -> new ResourceNotFoundException("Subject", subjectid)
// );
        
        Student astudent =student.get(); //convert from java 8 Optional to Student object
        Subject asubject =subject.get();  //convert from java 8 Optional to Subject object
        
        Set<Student> students =asubject.getStudents();//Get all students in the given subject
        students.add(astudent); //add the new student to the students'list of the selected subject
        asubject.setStudents(students);  //set the new students list to the selected subject
            return this.subjectrepo.save(asubject).getStudents(); //Save the subject object and return the students list
            
       // }).orElseThrow(() -> new ResourceNotFoundException("Lecturer", id));
    }
	
	
	//Method to add many new students to a subject.
		@PostMapping("/{subjectid}/students/") // Path variable names must match with method's signature variables.
	    public Set<Student> addStudentsToSubject(@Valid @PathVariable int subjectid, @RequestBody List<Student> studentList){
	       
			  // Finds a subject and adds the given student to the subject's set.
	        Optional<Subject> subject = this.subjectrepo.findById(subjectid);//.orElseThrow(
	        // () -> new ResourceNotFoundException("Subject", subjectid)
	         // );
	        Subject asubject =subject.get();  //convert from java 8 Optional to Subject object
	        Set<Student> students =asubject.getStudents();//Get all students in the given subject
			
	        
	        studentList.forEach(astudent->{ //Iterate through the Studentslist passed adding them to the subject
	    
	        	students.add(astudent); //add the new student to the students'list of the selected subject
	         
	        });
	         
	        asubject.setStudents(students);  //set the new students list to the selected subject
	            return this.subjectrepo.save(asubject).getStudents(); //Save the subject object and return the students list
	            
	       // }).orElseThrow(() -> new ResourceNotFoundException("Lecturer", id));
	    }
	
	
		//Method to remove a  student from a subject.
		@DeleteMapping("/{subjectid}/students/{studentId}") // Path variable names must match with method's signature variables.
	    public Set<Student> removeStudentFromSubject(@PathVariable int subjectid, @PathVariable int studentId){
	       
			// Finds a persisted student
	        Optional<Student> student = this.studentrepo.findById(studentId);//.orElseThrow(
	               // () -> new ResourceNotFoundException("Student", studentId)
	       // );
	        
	        // Finds a subject and adds the given student to the subject's set.
	        Optional<Subject> subject = this.subjectrepo.findById(subjectid);//.orElseThrow(
	        // () -> new ResourceNotFoundException("Subject", subjectid)
	// );
	        
	        Student astudent =student.get(); //convert from java 8 Optional to Student object
	        Subject asubject =subject.get();  //convert from java 8 Optional to Subject object
	        
	        Set<Student> students =asubject.getStudents();//Get all students in the given subject
	        students.remove(astudent); //removes the  student from the students'list of the selected subject
	        asubject.setStudents(students);  //set the new students list to the selected subject
	            return this.subjectrepo.save(asubject).getStudents(); //Save the subject object and return the students list
	            
	       // }).orElseThrow(() -> new ResourceNotFoundException("Lecturer", id));
	    }
		
		//Method to remove many  students from a subject.
				@DeleteMapping("/{subjectid}/students/") // Path variable names must match with method's signature variables.
			    public Set<Student> removeStudentsFromSubject(@Valid @PathVariable int subjectid, @RequestBody List<Student> studentList){
			       
					  // Finds a subject and adds the given student to the subject's set.
			        Optional<Subject> subject = this.subjectrepo.findById(subjectid);//.orElseThrow(
			        // () -> new ResourceNotFoundException("Subject", subjectid)
			         // );
			        Subject asubject =subject.get();  //convert from java 8 Optional to Subject object
			        Set<Student> students =asubject.getStudents();//Get all students in the given subject
					
			        
			        studentList.forEach(astudent->{ //Iterate through the Studentslist passed adding them to the subject
			    
			        	students.remove(astudent); //add the new student to the students'list of the selected subject
			         
			        });
			         
			        asubject.setStudents(students);  //set the new students list to the selected subject
			            return this.subjectrepo.save(asubject).getStudents(); //Save the subject object and return the students list
			            
			       // }).orElseThrow(() -> new ResourceNotFoundException("Lecturer", id));
			    }
	
	
			/*	//Method to get all subjects by a student .
				@GetMapping("/subjects/{studentid}") // Path variable names must match with method's signature variables.
			    public Set<Subject> getAllSubjectsByStudent(@Valid @PathVariable int studentid){
			       
					  // Finds a student using the studentid
			        Optional<Student> student = this.studentrepo.findById(studentid);//.orElseThrow(
			        // () -> new ResourceNotFoundException("Subject", subjectid)
			         // );
			        Student astudent =student.get();  //convert from java 8 Optional to Student object
			        Set<Subject> subjects= astudent.getSubjects();//Get all subjects in the given student
					
			      
			            return subjects; //Save the subject object and return the students list
			            
			       // }).orElseThrow(() -> new ResourceNotFoundException("Lecturer", id));
			    }
				*/
				
				//Method to get all students by a subject .
				@GetMapping("/students/{subjectId}") // Path variable names must match with method's signature variables.
			    public Set<Student> getAllStudentsBySubject(@Valid @PathVariable int subjectId){
			       
					  // Finds a subject using the subjectid
			        Optional<Subject> subject = this.subjectrepo.findById(subjectId);//.orElseThrow(
			        // () -> new ResourceNotFoundException("Subject", subjectid)
			         // );
			        Subject asubject =subject.get();  //convert from java 8 Optional to Subject object
			        Set<Student> students= asubject.getStudents();//Get all students in the given subject
					
			      
			            return students; //Save the subject object and return the students list
			            
			       // }).orElseThrow(() -> new ResourceNotFoundException("Lecturer", id));
			    }
			
	

}
