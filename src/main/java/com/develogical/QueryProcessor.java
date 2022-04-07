package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "MintChocChip";
        }
        return "";
    }

    public Integer largestNumberFrom(List<Integer> numbers){
        return Collections.max(numbers);
    }

    public List<Integer> stringToNumbers(String s) {
        String[] textnumbers = s.split(",");
        return Arrays.stream(textnumbers).map(((number) -> Integer.parseInt(number.trim()))).collect(Collectors.toList());
    }
}
