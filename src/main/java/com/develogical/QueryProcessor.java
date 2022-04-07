package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        if(query.toLowerCase().contains("square and a cube")) {
            ArrayList<Integer> integers = getNumbers(query);
            ArrayList<Integer> sqcbNumbers = new ArrayList<>();

            for(Integer integer: integers) {
                double number = integer.intValue();
                if((Math.sqrt(number) - Math.floor(Math.sqrt(number)))==0 &&
                (Math.cbrt(number) - Math.floor(Math.cbrt(number)))==0) {
                    sqcbNumbers.add(integer);
                }
            }

            return sqcbNumbers.toString();
        }
        return "";
    }

    private ArrayList<Integer> getNumbers(String query) {
        String queryWithoutCommas = query.replace(",", "");
        String[] queryParts = queryWithoutCommas.split(" ");
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
}
