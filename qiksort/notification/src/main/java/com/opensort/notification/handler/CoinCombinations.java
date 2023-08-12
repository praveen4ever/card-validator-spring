package com.opensort.notification.handler;

public class CoinCombinations {
    public static void countPaymentCombinations(int price, int[] coinValues) {
        int ways = 0;
        for (int num10p = 0; num10p <= price / coinValues[0]; num10p++) {
            for (int num20p = 0; num20p <= price / coinValues[1]; num20p++) {
                for (int num50p = 0; num50p <= price / coinValues[2]; num50p++) {
                    if ((num10p * coinValues[0] + num20p * coinValues[1] + num50p * coinValues[2]) == price) {
                        ways++;
                        System.out.println("10p: " + num10p + ", 20p: " + num20p + ", 50p: " + num50p);
                    }
                }
            }
        }
        System.out.println("Total ways: " + ways);
    }

    public static void main(String[] args) {
        int carParkPrice = 70;
        int[] coinValues = { 10, 20, 50 };

        countPaymentCombinations(carParkPrice, coinValues);
    }
}

