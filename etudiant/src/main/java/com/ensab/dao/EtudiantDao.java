package com.ensab.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ensab.entities.Etudiant;


public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
	
	public Etudiant findByEmail(String email);
	
	long countByEmail(String email);
	
	List<Etudiant> findByNomPrenomOrEmail(String nomPrenom,String email);
	
	/*
	 * @Query("select e from Etudiant e where e.email like :p")
	 * 
	 * public Page<Etudiant> chercherEtudiants(@Param("p")String partEmail,Pageable
	 * pageable);
	 */
	
}

