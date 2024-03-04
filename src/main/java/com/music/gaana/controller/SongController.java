package com.music.gaana.controller;

/*
 * Create a controller for the methods available in SongService
 * Autowire the SongService class
 * use throws keyword wherever required for exception handling
 */

import java.util.List;

import com.music.gaana.exceptions.SongAlreadyExistsException;
import com.music.gaana.exceptions.SongNotFoundException;
import com.music.gaana.model.Song;
import com.music.gaana.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping
@CrossOrigin
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/song")
    public Song saveSong(@RequestBody Song song) throws SongAlreadyExistsException {
        return songService.saveSong(song);
    }

    @DeleteMapping("/song/{entityId}")
    public String deleteSong(@PathVariable String entityId) throws SongNotFoundException {
        return songService.deleteSong(entityId);
    }

    @GetMapping("/saved-songs")
    public List<Song> getSavedSongs() {
        return songService.getSavedSongs();
    }

    @GetMapping(value = "/all-songs", produces = "application/json")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

}