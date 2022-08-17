package com.learnsite.learnsite.api.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Session {
@Id
private String id;
private Date date;
private String duration;
//list of enrolled users
private List<User> user;
private Formation formation;


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
