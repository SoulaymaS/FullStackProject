package com.learnsite.learnsite.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learnsite.learnsite.api.models.ERole;
import com.learnsite.learnsite.api.models.Role;

public interface RoleRepository extends MongoRepository<Role,String>{
Optional<Role> findByName(ERole name);
}
