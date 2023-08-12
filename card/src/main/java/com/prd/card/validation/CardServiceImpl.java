package com.prd.card.validation;

import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Override
    public Boolean checkValidCard(String cardNumber) throws CardValidationException {
        boolean isSecond = false;
        int totalCount = 0;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(cardNumber.charAt(i))) throw new CardValidationException("Card is invalid");
            int digit = cardNumber.charAt(i) - '0';
            if (isSecond) {
                digit = digit * 2;
                if (digit > 9) digit = digit / 10 + digit % 10;
            }
            totalCount += digit;
            isSecond = !isSecond;

        }
        return totalCount % 10 == 0;
    }
}
