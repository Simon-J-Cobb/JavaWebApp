package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class QueryProcessor {

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

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

            for (Integer integer : integers) {
                double number = integer.intValue();
                if ((Math.sqrt(number) - Math.floor(Math.sqrt(number))) == 0 &&
                        (Math.cbrt(number) - Math.floor(Math.cbrt(number))) == 0) {
                    sqcbNumbers.add(integer);
                }
            }

            return createReturnStringFromIntList(sqcbNumbers);
        }
        if(query.toLowerCase().contains("multiplied")) {
            ArrayList<Integer> integers = getNumbers(query);
            return String.valueOf(integers.get(0) * integers.get(1));
        }
        if(query.toLowerCase().contains("minus")) {
            ArrayList<Integer> integers = getNumbers(query);
            return String.valueOf(integers.get(0) - integers.get(1));
        }
        if(query.toLowerCase().contains("largest")) {
            return String.valueOf(largestNumberFrom(stringToNumbers(query.toLowerCase(Locale.ROOT).split(":")[2])));
        }
        if(query.toLowerCase().contains("theresa may")){
            return "2016";
        }

        if(query.toLowerCase().contains(("james bond"))) {
            return "Sean Connery";
        }

        if(query.toLowerCase().contains(("eiffel tower"))) {
            return "Paris";
        }
        if(query.toLowerCase(Locale.ROOT).contains("following numbers are primes")){
            return createReturnStringFromIntList(primeNumbersFrom(stringToNumbers(query.toLowerCase(Locale.ROOT).split(":")[2])));
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

    public List<Integer> primeNumbersFrom(List<Integer> numbers){
        return numbers.stream().filter((x) -> isPrime(x)).collect(Collectors.toList());
    }

    public List<Integer> stringToNumbers(String s) {
        String[] textnumbers = s.split(",");
        return Arrays.stream(textnumbers).map(((number) -> Integer.parseInt(number.trim()))).collect(Collectors.toList());
    }

    public String createReturnStringFromIntList(List<Integer> ints) {
        String returnString = "";
        for(Integer integer : ints) {
            returnString += " "  + integer.toString();
        }
        return  returnString;
    }
}
