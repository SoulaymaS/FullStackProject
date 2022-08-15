package com.learnsite.learnsite.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learnsite.learnsite.api.models.Theme;

public interface ThemeRepository extends MongoRepository<Theme, String>{

}
