package com.develogical;

import java.util.*;
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
        if(query.toLowerCase().contains("plus")) {
            ArrayList<Integer> integers = getNumbers(query);
            return String.valueOf(integers.get(0) + integers.get(1));
        }
        if(query.toLowerCase().contains("largest")) {
            return String.valueOf(largestNumberFrom(stringToNumbers(query.toLowerCase(Locale.ROOT).split(":")[2])));
        }
        return "";
    }

    private ArrayList<Integer> getNumbers(String query) {
        String[] queryParts = query.split(" ");
        ArrayList<Integer> integers = new ArrayList<>();
        for(String queryPart : queryParts) {
            try {
                integers.add(Integer.parseInt(queryPart));
            } catch (Exception e) {}
        }

        return integers;
    }

    public Integer largestNumberFrom(List<Integer> numbers){
        return Collections.max(numbers);
    }

    public List<Integer> stringToNumbers(String s) {
        String[] textnumbers = s.split(",");
        return Arrays.stream(textnumbers).map(((number) -> Integer.parseInt(number.trim()))).collect(Collectors.toList());
    }
}
