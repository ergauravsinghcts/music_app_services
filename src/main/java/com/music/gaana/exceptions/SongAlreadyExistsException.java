package com.music.gaana.exceptions;

/*
 * StockAlreadyExistsException EXTENDS Exception
 */

 public class SongAlreadyExistsException extends Exception {
    public SongAlreadyExistsException(String message) {
        super(message);
    }
}
