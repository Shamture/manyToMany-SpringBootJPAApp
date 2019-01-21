package com.manyToMany.SpringBootJPAApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manyToMany.SpringBootJPAApp.pojos.Subjectt;

@Repository
public interface SubjectObjRepository extends JpaRepository<Subjectt, Integer>{

	
}
