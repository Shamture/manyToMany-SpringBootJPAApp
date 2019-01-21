package com.manyToMany.SpringBootJPAApp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.manyToMany.SpringBootJPAApp.models.Student;
import com.manyToMany.SpringBootJPAApp.models.Subject;
import com.manyToMany.SpringBootJPAApp.repository.StudentRepository;
import com.manyToMany.SpringBootJPAApp.repository.SubjectRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = " com.manyToMany.SpringBootJPAApp")
public class ManyToManySpringBootJpaAppApplication{
//implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
 
	public static void main(String[] args) {
		SpringApplication.run(ManyToManySpringBootJpaAppApplication.class, args);
	}
 
	/*@Transactional
	@Override
	public void run(String... arg0) throws Exception {
		Student jack = new Student("Jack");
		Student peter = new Student("Peter");
		
		Subject math = new Subject("Mathematics");
		Subject computer = new Subject("Compter");
		
		///subjectRepository.save(math);
		//subjectRepository.save(computer);
		
		Set<Subject> subjects = new HashSet<Subject>();
		subjects.add(math);
		subjects.add(computer);
		
		jack.setSubjects(subjects);
		peter.setSubjects(subjects);
		
		studentRepository.save(jack);
		studentRepository.save(peter);
		
		
		Set<Student> students = new HashSet<Student>();
		students.add(jack);
		students.add(peter);
		
		math.setStudents(students);
		computer.setStudents(students);
		
		subjectRepository.save(math);
		subjectRepository.save(computer);
		
		List<Student> studentLst = studentRepository.findAll();
		List<Subject> subLst = subjectRepository.findAll();
		
		System.out.println(studentLst.size());
		System.out.println(subLst.size());
		
		
		System.out.println("===================Students info:==================");
		studentLst.forEach(student->System.out.println(student.toString()));
		
		System.out.println("===================Students info:==================");
		subLst.forEach(subject->System.out.println(subject.toString()));
	}*/
}
