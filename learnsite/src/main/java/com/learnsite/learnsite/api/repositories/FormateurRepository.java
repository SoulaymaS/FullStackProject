package com.learnsite.learnsite.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learnsite.learnsite.api.models.Formateur;

public interface FormateurRepository extends MongoRepository<Formateur, String>{

}
