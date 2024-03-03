package com.music.gaana.exceptions;

/**
 * SongNotFoundException EXTENDS Exception
 */

public class SongNotFoundException extends Exception {
    public SongNotFoundException(String message) {
        super(message);
    }
}