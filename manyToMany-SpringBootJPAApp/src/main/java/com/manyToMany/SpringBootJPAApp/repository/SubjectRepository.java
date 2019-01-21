package com.manyToMany.SpringBootJPAApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.manyToMany.SpringBootJPAApp.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	
}