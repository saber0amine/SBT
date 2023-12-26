package com.ensab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensab.dao.EtudiantDao;
import com.ensab.entities.Etudiant;

@Controller
public class EtudiantController {
@Autowired
private EtudiantDao dao;

@RequestMapping(value="/")
public String accueil(Model m) {
m.addAttribute("listeE" ,dao.findAll()); 
return "index"; 
}


@RequestMapping(value="/SEtudiant",method=RequestMethod.POST)
public String save(Model m, @RequestParam (value="nomPr") String nomPrenom,String email) {
Etudiant e= new Etudiant(nomPrenom, email);
dao.save(e);
m.addAttribute("listeE",dao.findAll()); 
return "index";
}

@RequestMapping(value="/REtudiant",method=RequestMethod.POST)
public String research(Model m, String email) {
	
List<Etudiant> lst=new ArrayList<Etudiant>();

	Etudiant e=dao.findByEmail(email);
	
	if (e!= null) lst.add(e); 
	m.addAttribute("listeE" ,lst);
return "index";
}

@RequestMapping (value="/SupEtudiant{id}")
public String delete(Model m, long id) {
dao.deleteById(id);
return accueil(m);
} 

}
