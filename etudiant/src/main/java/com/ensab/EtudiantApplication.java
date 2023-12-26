package com.ensab;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ensab.dao.EtudiantDao;
import com.ensab.entities.Etudiant;

@SpringBootApplication
public class EtudiantApplication {
	
	
	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(EtudiantApplication.class, args);
		EtudiantDao dao= context.getBean(EtudiantDao.class);
		dao.save(new Etudiant("EnsaB", "ensab@uhp.ac.ma"));
		dao.save(new Etudiant("Ensa", "ensa@ac.ma"));
		List<Etudiant> lst= dao.findAll();
		for (Etudiant e: lst)
		System.out.println("Id: "+ e.getId()+ "NomPrenom: "+ 
		e.getNomPrenom()+ " Email: "+e.getEmail());
		dao.deleteById(2L);
		for (Etudiant e: dao.findAll())
		System.out.println("Id: "+ e.getId()+ "NomPrenom: "+ 
		e.getNomPrenom()+ " Email: "+e.getEmail());
		
	
/*	for(Etudiant e:dao.findByNomPrenomOrEmail("EnsaB" ,"ensaT@ac.ma"))
		System.out.println("Id: "+ e.getId()+ " NomPrenom: "+ e.getNomPrenom()+ " Email: "+e.getEmail());
		Page<Etudiant> pageEtudiants=dao.chercherEtudiants("%", PageRequest.of(0, 5));
		System.out.println("Page "+ pageEtudiants.getNumber()+ 1 + " / " + pageEtudiants.getTotalPages());
		for(Etudiant e: pageEtudiants.getContent())
		System.out.println("Id: "+ e.getId()+ " NomPrenom: "+ 
		e.getNomPrenom()+ " Email: "+e.getEmail()); } */
}
}


