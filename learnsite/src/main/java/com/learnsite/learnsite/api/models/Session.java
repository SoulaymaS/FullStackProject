package com.learnsite.learnsite.api.models;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Session {
@Id
private String id;

private String titre;
private Date date;
private String duration;

private Float prix;
private Float heureprix;
//list of enrolled users
@DBRef
private Set<User> users= new HashSet<>();
@DBRef
private Formation formation;
@DBRef
private Formateur formateur;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}


//Getters and Setters

public boolean isSessionStatus() {
	return sessionStatus;
}
public void setSessionStatus(boolean sessionStatus) {
	this.sessionStatus = sessionStatus;
}
private boolean sessionStatus; 


public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public Formation getFormation() {
	return formation;
}
public void setFormation(Formation formation) {
	this.formation = formation;
}
public Float getPrix() {
	return prix;
}
public void setPrix(Float prix) {
	this.prix = prix;
}
public Float getHeureprix() {
	return heureprix;
}
public void setHeureprix(Float heureprix) {
	this.heureprix = heureprix;
}
public Formateur getFormateur() {
	return formateur;
}
public Set<User> getUsers() {
	return users;
}
public void setUsers(Set<User> users) {
	this.users = users;
}
public void setFormateur(Formateur formateur) {
	this.formateur = formateur;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
}
