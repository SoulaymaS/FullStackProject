package com.learnsite.learnsite.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Themes")
public class Theme {

	@Id
	private String id;
	private String title;
	@DBRef
	private List<Formation> formation;
	
	
	//Getters and Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Formation> getFormation() {
		return formation;
	}
	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}
}
