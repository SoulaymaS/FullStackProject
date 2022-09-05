package com.learnsite.learnsite.api.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Formateurs")
public class Formateur {
@Id
private String id;
private String nom;
private String username;
private String prenom;
@DBRef User user;
private String cin;
private String profession;

@DBRef
private Session session;


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Session getSession() {
	return session;
}
public void setSession(Session session) {
	this.session = session;
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
