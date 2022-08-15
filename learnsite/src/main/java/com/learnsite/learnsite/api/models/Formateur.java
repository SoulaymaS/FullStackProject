package com.learnsite.learnsite.api.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Formateurs")
public class Formateur {
@Id
private String id;
private String nom;
private String prenom;
private String cin;
private String profession;
@DBRef
private Formation formation;

public Formation getFormation() {
	return formation;
}
public void setFormation(Formation formation) {
	this.formation = formation;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getProfession() {
	return profession;
}
public void setProfession(String profession) {
	this.profession = profession;
}

}
