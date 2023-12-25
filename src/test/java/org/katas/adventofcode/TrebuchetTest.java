package org.katas.adventofcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Integer.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.katas.adventofcode.Trebuchet.getCalibrationFromText;
import static org.katas.adventofcode.Trebuchet.getCalibrationValueFromLine;

class TrebuchetTest {

    @ParameterizedTest(name = "given text {0} should return {1}")
    @CsvSource({
            "1,11"
            , "2,22"
            , "3,33"
            , "3a,33"
            , "a3,33"
            , "a2,22"
            , "1a2,12"
            , "1a12,12"
    })
    void given_the_string_should_return_digits_as_expected(String input, String expected) {
        assertThat(getCalibrationValueFromLine(input)).isEqualTo(valueOf(expected));
    }

    @Test
    @DisplayName("given a two lines text should return the sum of each calibration value")
    void firstSimpleTest() {
        var text = """
                1abc2
                  pqr3stu8vwx
                  a1b2c3d4e5f
                  treb7uchet
                """;

        assertThat(getCalibrationFromText(text)).isEqualTo(142);
    }
}