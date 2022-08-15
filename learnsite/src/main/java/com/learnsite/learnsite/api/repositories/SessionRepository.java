package com.learnsite.learnsite.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learnsite.learnsite.api.models.Session;

public interface SessionRepository extends MongoRepository<Session, String>{

}
