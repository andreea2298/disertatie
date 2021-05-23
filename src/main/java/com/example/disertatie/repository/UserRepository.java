package com.example.disertatie.repository;

import com.example.disertatie.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
