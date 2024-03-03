package com.music.gaana.serviceImpl;

/**
 * The class should implement the SongService interface.
 * If a song is not found, it should throw SongNotFoundException. 
 * If a song already exists, it should throw a SongAlreadyExistsException.
 * Use a RestTemplate bean to make calls to a third-party API.
 * Utilize RestTemplate to retrieve stocks from the third-party API, GAANA_API_URL.
 * The value of GAANA_API_URL should be obtained from application.properties.
 */

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.music.gaana.exceptions.SongAlreadyExistsException;
import com.music.gaana.exceptions.SongNotFoundException;
import com.music.gaana.model.Song;
import com.music.gaana.model.SongList;
import com.music.gaana.repository.SongRepository;
import com.music.gaana.service.SongService;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private RestTemplate restTemplate;

    // api url from properties file
    @Value("${GAANA_API_URL}")
    private String gaanaAPIUrl;

    @Override
    public Song saveSong(Song song) throws SongAlreadyExistsException {
        if (songRepository.existsById(song.getEntity_id())) {
            throw new SongAlreadyExistsException("Song already exists");
        }
        return songRepository.save(song);
    }

    @Override
    public String deleteSong(String entityId) throws SongNotFoundException {
        if (!songRepository.existsById(entityId)) {
            throw new SongNotFoundException("Song not found");
        }
        songRepository.deleteById(entityId);
        return "Song deleted";
    }

    @Override
    public List<Song> getSavedSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<Song> getAllSongs() {
        return getGaanaSongs();
    }

    public List<Song> getGaanaSongs() {
        /**
         * construct the URL and utilize RestTemplate to retrieve stocks
         * from the third-party API, GAANA_API_URL.
         * Employ a RestTemplate bean to make calls to the third-party API.
         * Obtain the value of GAANA_API_URL from application.properties.
         */

        System.out.println("url :" + gaanaAPIUrl);

        // create HTTP headers and set host name ans postman host
        HttpHeaders headers = new HttpHeaders();
        headers.set("Host", "gaana.com");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                gaanaAPIUrl, HttpMethod.POST, entity, String.class);

        // ResponseEntity<String> responseEntity = restTemplate.exchange(
        //         gaanaAPIUrl, HttpMethod.POST,
        //         new HttpEntity<String>(null, headers), String.class);

        System.err.println(responseEntity.getBody());

        // use JSONObject from org.json to parse the response from the API
        JSONObject response = restTemplate.postForObject(gaanaAPIUrl, null, JSONObject.class);

        // convert the response.entities to a SongList object
        SongList songList = (SongList) response.getJSONArray("entities").toList();

        // HttpHeaders headers = new HttpHeaders();
        // headers.set("Host", "www.example.com");
        // headers.set("User-Agent", "whatever");

        return songList.getSongs();

    }
}