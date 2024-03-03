package com.music.gaana.model;

/*
 * The data field should be of type List<Song>.
 * 
 * Use the Lombok library to automatically generate
 * a no-args constructor, an all-args constructor,
 * getters, setters, and the toString() method.
 */

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongList {
    private List<Song> songs;
}



