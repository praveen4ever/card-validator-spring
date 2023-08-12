package com.prd.card.validation;

public class CardValidationException extends RuntimeException{
    public CardValidationException(String message){
        super(message);
    }
}
