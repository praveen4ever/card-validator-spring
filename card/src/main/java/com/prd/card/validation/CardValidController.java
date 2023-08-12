package com.prd.card.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card/api")
public class CardValidController {

    private final CardService cardService;

    @Autowired
    public CardValidController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<String> validCard(@PathVariable("number") String cardNumber) {
        try {
            if (cardService.checkValidCard(cardNumber)) {
                return ResponseEntity.ok("Valid Card");
            } else {
                return ResponseEntity.badRequest().body("Invalid Card");
            }
        } catch (CardValidationException e) {
            return ResponseEntity.badRequest().body("Invalid Input");
        }
    }
}
