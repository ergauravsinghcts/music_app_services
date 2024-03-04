package com.music.gaana.repository;

/**
 * create a UserRepository interface using mongo repository to perform the
 * CRUD operations:
 * 
 */

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.music.gaana.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // validate user by emailId and password
    public Optional<User> findByEmailIdAndPassword(String emailId, String password);

}
