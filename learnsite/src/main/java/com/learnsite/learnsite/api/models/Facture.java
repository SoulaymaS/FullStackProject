package com.learnsite.learnsite.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Factures")
public class Facture {
@Id
private String id;
private Long number;
private Formateur formateur;
private float total; 
private float hour_price; 
private boolean status; // true : payed, false: unpaid 
private Facture facture;


//Getters and Setters
public Facture getFacture() {
	return facture;
}
public void setFacture(Facture facture) {
	this.facture = facture;
}

public Long getNumber() {
	return number;
}
public void setNumber(Long number) {
	this.number = number;
}
public Formateur getFormateur() {
	return formateur;
}
public void setFormateur(Formateur formateur) {
	this.formateur = formateur;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}

public float getHour_price() {
	return hour_price;
}
public void setHour_price(float hour_price) {
	this.hour_price = hour_price;
}
//public double bill() {
//	addition=Formateur.getSupplment();
//	for (Food food : foods) {
//		addition +=food.getPrix();
//	}
//	return addition;
//}
}
