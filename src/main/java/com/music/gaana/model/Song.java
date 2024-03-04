package com.music.gaana.model;

/**
 * Song class has been created to store the song details.
 *
 * "language": "Hindi",
 * "name": "Jai Jai Shri Ram Jai Shri Ram",
 * "artwork":
 * "https://a10.gaanacdn.com/gn_img/albums/MmqK5EKwRO/qK5ZGzgz3w/size_m.jpg",
 * "entity_id": "55927670",
 * "favorite_count": 2207,
 * "premium_content": "0",
 * 
 * * Use Lombok to generate no-args constructor,All Argument constructor,
 * getters,
 * setters, and toString() method.
 * Use @Document annotation to specify the collection name in mongoDB.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "song")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Song {
    
    private String language;
    private String name;
    private String artwork;
    @Id
    private String entity_id;
    private int favorite_count;
    private String premium_content;
}
