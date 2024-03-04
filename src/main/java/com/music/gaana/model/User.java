package com.music.gaana.model;

/*
 * create the following fields 
 * emailId,password,userName,mobile
 * use Lombok to generate no-args constructor,All Argument constructor, getters, setters, and toString() method.
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
@Document(collection = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    private String emailId;
    private String password;
    private String userName;
    private String mobile;
}