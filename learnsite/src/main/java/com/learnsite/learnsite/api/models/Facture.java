package com.learnsite.learnsite.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Factures")
public class Facture {
@Id
private String id;
@DBRef
private Formateur formateur;
private float somme; 
private float price; 
private boolean status; // true : payed, false: unpaid 



public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Formateur getFormateur() {
	return formateur;
}
public void setFormateur(Formateur formateur) {
	this.formateur = formateur;
}
public float getSomme() {
	return somme;
}
public void setSomme(float somme) {
	this.somme = somme;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}



//Getters and Setters




}
