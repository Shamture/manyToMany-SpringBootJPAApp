package com.manyToMany.SpringBootJPAApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.manyToMany.SpringBootJPAApp.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	//List<Student> findAll();
}
