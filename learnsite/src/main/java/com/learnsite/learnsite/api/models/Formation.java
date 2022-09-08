package com.learnsite.learnsite.api.models;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "formations")
//attributes
public class Formation {
@Id
private String id;
private String title;
private String description;
//define list of sessions if available
//define theme
@DBRef
private Theme theme;

//Getters and Setters
public String getTitle() {
	return title;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}



public Theme getTheme() {
	return theme;
}
public void setTheme(Theme theme) {
	this.theme = theme;
}



}
