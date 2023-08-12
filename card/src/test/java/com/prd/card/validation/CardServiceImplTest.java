package com.prd.card.validation;

import org.junit.jupiter.api.*;

public class CardServiceImplTest {
    private static final String VALID_CARD_NUMBER = "4242424242426742";
    private static final String INVALID_CARD_NUMBER1 = "1111111111111111";

    private static final String INVALID_CARD_NUMBER_2 = "112CV";

    private CardService cardService;

    @BeforeEach
    void testCardService(){
        this.cardService = new CardServiceImpl();
    }

    @Test
    @Order(1)
    @DisplayName("Valid Card Number")
    void testValidCardNumber()  {
        Assertions.assertTrue(cardService.checkValidCard(VALID_CARD_NUMBER), "Expected Valid Card number");
    }

    @Test
    @Order(2)
    @DisplayName("Invalid Card Number")
    void testInValidCardNumber() {
        Assertions.assertFalse(cardService.checkValidCard(INVALID_CARD_NUMBER1),"Expected Invlid Card Number");
    }

    @Test
    @Order(3)
    @DisplayName("Invalid Card Pattern")
    void testInValidCardException() {
        Assertions.assertThrows(CardValidationException.class,() -> cardService.checkValidCard(INVALID_CARD_NUMBER_2), "Exception in checking Invalid card Number");
    }

}
