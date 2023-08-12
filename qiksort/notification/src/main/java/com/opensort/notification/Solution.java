package com.opensort.notification;


public class Solution {

    public static String run(String startPosition, int R, int C) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */

        int startRow = Character.getNumericValue(startPosition.charAt(0));
        int startColumn = startPosition.charAt(1) - 'a' + 1;

        int endRow = (startRow - 1 + R) % 8 + 1;
        int endColumn = (startColumn - 1 + C) % 8 + 1;

        char endColumnLetter = (char) (endColumn + 'a' - 1);


        String endPosition = String.valueOf(endRow) + endColumnLetter;

        return endPosition;
    }
}
