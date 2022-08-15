package com.learnsite.learnsite.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Users")
public class User {
@Id
private String id;
private String nom;
private String prénom;
private String email;
private String password;
private Role role;
//Getters and Setters
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrénom() {
	return prénom;
}
public void setPrénom(String prénom) {
	this.prénom = prénom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}



}
