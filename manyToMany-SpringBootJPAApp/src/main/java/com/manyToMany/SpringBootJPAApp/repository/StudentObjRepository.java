package com.manyToMany.SpringBootJPAApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manyToMany.SpringBootJPAApp.pojos.Studentt;

@Repository
public interface StudentObjRepository extends JpaRepository<Studentt, Integer>{

	
}

