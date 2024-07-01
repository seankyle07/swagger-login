package com.camspot.sysarach.Repository;


import com.camspot.sysarach.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, Integer>

    {
        Optional<User> findByUsernameAndPassword(String username, String password);

        Optional<User> findByUsername(String username);
    }



