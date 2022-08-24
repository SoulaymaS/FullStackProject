package com.learnsite.learnsite.api.models;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="roles")
public class Role {
@Id
private String Id;
private ERole name;
public Role() {
}
public Role(ERole name) {
	this.name=name;
}

public ERole getName() {
	return name;
}
public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public void setName(ERole name) {
	this.name = name;
}




}
