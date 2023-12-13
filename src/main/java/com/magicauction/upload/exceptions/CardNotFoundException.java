package com.magicauction.upload.exceptions;

public class CardNotFoundException extends RuntimeException{

    public CardNotFoundException(String message) {
        super(String.format("Could not Found the card you are looking for... - Message [%s]", message));
    }
}
