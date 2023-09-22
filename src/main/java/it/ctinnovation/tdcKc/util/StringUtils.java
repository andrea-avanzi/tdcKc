package it.ctinnovation.tdcKc.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringUtils {
    public static List<String> tokenizeString(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList(); // return an empty list if the input is null or empty
        }

        // Split the string by comma and return the resulting array as a list
        return Arrays.asList(input.split("\\s*,\\s*"));
    }
}
