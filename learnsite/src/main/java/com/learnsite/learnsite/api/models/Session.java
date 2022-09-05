package com.learnsite.learnsite.api.models;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Session {
@Id
private String id;
private Date date;
private String duration;
private Boolean status;
private Float prix;
public Float getPrix() {
	return prix;
}
public void setPrix(Float prix) {
	this.prix = prix;
}
//list of enrolled users
private List<User> user;
@DBRef
private Formation formation;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
//Getters and Setters
public List<User> getUser() {
	return user;
}
public void setUser(List<User> user) {
	this.user = user;
}
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
}
