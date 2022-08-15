package com.learnsite.learnsite.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learnsite.learnsite.api.models.Formation;


public interface FormationRepository extends MongoRepository<Formation, String>{

}
