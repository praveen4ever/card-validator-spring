package com.prd.card.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CardValidControllerTest {

    private static final String VALID_CARD_NUMBER = "4242424242426742";
    private static final String INVALID_CARD_NUMBER1 = "1111111111111111";

    private static final String INVALID_CARD_NUMBER_2 = "112CV";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Mock
    private CardServiceImpl cardService;
    @InjectMocks
    private CardValidController cardValidController;

    @Test
    @DisplayName("OK status")
    @Order(1)
    public void okStatus(){
        when(cardService.checkValidCard(VALID_CARD_NUMBER)).thenReturn(true);
        ResponseEntity<String> responseEntity = cardValidController.validCard(VALID_CARD_NUMBER);
        assertEquals(200,responseEntity.getStatusCode().value(),"Valid Status Code");
        assertEquals("Valid Card",responseEntity.getBody(),"Valid Message");
        verify(cardService,times(1)).checkValidCard(VALID_CARD_NUMBER);
        verifyNoMoreInteractions(cardService);
    }
    @Test
    @Order(2)
    @DisplayName("Not Valid")
    public void notValidStatus(){
        when(cardService.checkValidCard(INVALID_CARD_NUMBER1)).thenReturn(false);
        ResponseEntity<String> responseEntity = cardValidController.validCard(INVALID_CARD_NUMBER1);
        assertEquals(400,responseEntity.getStatusCode().value());
        assertEquals("InValid Card".toLowerCase(), Objects.requireNonNull(responseEntity.getBody()).toLowerCase());
        verify(cardService,times(1)).checkValidCard(INVALID_CARD_NUMBER1);
        verifyNoMoreInteractions(cardService);

    }

    @Test
    @Order(3)
    @DisplayName("Invalid details")
    public void inValidCard(){
        when(cardService.checkValidCard(INVALID_CARD_NUMBER_2)).thenThrow(new CardValidationException("Invalid Input"));
        ResponseEntity<String> responseEntity=cardValidController.validCard(INVALID_CARD_NUMBER_2);
        assertEquals("InValid input".toLowerCase(), Objects.requireNonNull(responseEntity.getBody()).toLowerCase());
        verify(cardService,times(1)).checkValidCard(INVALID_CARD_NUMBER_2);
        verifyNoMoreInteractions(cardService);
    }
}
