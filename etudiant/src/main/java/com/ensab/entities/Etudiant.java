package com.ensab.entities;
import jakarta.annotation.Generated;
import jakarta.persistence.*;


@Entity
@Table(name="TEtudiant")
public class Etudiant {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column (name="NomPrenom")
private String nomPrenom;
private String email;
public Etudiant() { }
public Etudiant(String nomPrenom, String email) {
this.nomPrenom = nomPrenom;this.email = email; }
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNomPrenom() {
	return nomPrenom;
}
public void setNomPrenom(String nomPrenom) {
	this.nomPrenom = nomPrenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}





}
