package com.prd.card.validation;

public interface CardService {
    Boolean checkValidCard(String cardNumber) throws CardValidationException;
}
