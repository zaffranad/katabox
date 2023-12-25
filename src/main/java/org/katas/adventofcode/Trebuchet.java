package org.katas.adventofcode;

import static java.lang.Character.isDigit;
import static java.lang.Integer.valueOf;

public class Trebuchet {
    public static Integer getCalibrationValueFromLine(String line) {
        var digits = extractFirstAndLastDigitalChar(line);
        if (digits.isEmpty()) {
            throw new RuntimeException("No calibration value found");
        }
        if (digits.length() == 1) {
            return digitShouldBeDoubled(digits);
        }
        if (digits.length() > 2) {
            return getOnlyFirstAndLastDigits(digits);
        }
        return valueOf(digits);
    }

    private static Integer digitShouldBeDoubled(String digits) {
        return valueOf(digits + digits);
    }

    private static Integer getOnlyFirstAndLastDigits(String digits) {
        return valueOf(
                digits.charAt(0) + digits.substring(digits.length() - 1)
        );
    }

    private static String extractFirstAndLastDigitalChar(String line) {
        StringBuilder result = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static Integer getCalibrationFromText(String text) {
        return text.lines()
                .map(Trebuchet::getCalibrationValueFromLine)
                .mapToInt(Integer::intValue)
                .sum();
    }
}