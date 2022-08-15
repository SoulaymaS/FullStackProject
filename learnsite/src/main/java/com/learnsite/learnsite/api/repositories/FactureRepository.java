package com.learnsite.learnsite.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learnsite.learnsite.api.models.Facture;

public interface FactureRepository extends MongoRepository<Facture, String>{

}
