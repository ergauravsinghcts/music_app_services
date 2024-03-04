package com.music.gaana.repository;

/**
 * create a SongRepository interface using mongo repository to perform the
 * CRUD operations:
 * 
 */


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.music.gaana.model.Song;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {
    
}