# card-validator-spring

1. Take a credit card number.

2. Start from the rightmost digit (also known as the check digit) and move left, doubling the value of every second digit.

3. If the product of this doubling operation is greater than 9 (e.g., 8 * 2 = 16), then sum the digits of the products. (e.g., 16: 1 + 6 = 7, 18: 1 + 8 = 9).

4. Take the sum of all the digits.

5. If the total modulo 10 is equal to 0 (if the total ends in zero) then the number is valid according to the Luhn formula; else it is not valid.

---------------
Spring REST API

Junit test cases
