package com.solvians.showcase;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ISINGenerator {

    private static final Map<Character, Integer> CHAR_TO_INT = Map.ofEntries(
            Map.entry('A', 10), Map.entry('B', 11), Map.entry('C', 12), Map.entry('D', 13),
            Map.entry('E', 14), Map.entry('F', 15), Map.entry('G', 16), Map.entry('H', 17),
            Map.entry('I', 18), Map.entry('J', 19), Map.entry('K', 20), Map.entry('L', 21),
            Map.entry('M', 22), Map.entry('N', 23), Map.entry('O', 24), Map.entry('P', 25),
            Map.entry('Q', 26), Map.entry('R', 27), Map.entry('S', 28), Map.entry('T', 29),
            Map.entry('U', 30), Map.entry('V', 31), Map.entry('W', 32), Map.entry('X', 33),
            Map.entry('Y', 34), Map.entry('Z', 35)
    );

    public static String generateISIN() {
        StringBuilder isin = new StringBuilder();

        isin.append((char) ('A' + ThreadLocalRandom.current().nextInt(26)));
        isin.append((char) ('A' + ThreadLocalRandom.current().nextInt(26)));

        for (int i = 0; i < 9; i++) {
            int rand = ThreadLocalRandom.current().nextInt(36);
            if (rand < 10) {
                isin.append(rand);
            } else {
                isin.append((char) ('A' + rand - 10));
            }
        }

        char checkDigit = calculateCheckDigit(isin.toString());
        isin.append(checkDigit);

        return isin.toString();
    }

    public static char calculateCheckDigit(String isin) {
        StringBuilder numeric = new StringBuilder();

        for (char c : isin.toCharArray()) {
            if (Character.isDigit(c)) {
                numeric.append(c);
            } else if (Character.isLetter(c)) {
                int num = CHAR_TO_INT.get(c);
                numeric.append(num);
            }
        }

        String reversed = numeric.reverse().toString();
        int sum = 0;

        for (int i = 0; i < reversed.length(); i++) {
            int digit = Character.getNumericValue(reversed.charAt(i));
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }
            sum += digit;
        }

        int check = (10 - (sum % 10)) % 10;
        return (char) ('0' + check);
    }
}
