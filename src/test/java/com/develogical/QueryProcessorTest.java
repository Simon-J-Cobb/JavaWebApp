package com.develogical;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void returnTeamName() {
        assertThat(queryProcessor.process("what is your name"), containsString("MintChocChip"));
    }

    @Test
    public void returnSumOfNumbers() {
        assertThat(queryProcessor.process("what is 1 plus 2"), containsString("3"));
    }

    @Test
    public void returnLargestNumber() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(2021);
        numbers.add(20452);
        assertThat(queryProcessor.largestNumberFrom(numbers), is(20452));
    }

    @Test
    public void returnsNumberThatsSquareAndCube() {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 64, 729, 30, 20"), containsString("64 729"));
    }

    @Test
    public void stringToNumbers(){
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(2021);
        numbers.add(20452);
        assertThat(queryProcessor.stringToNumbers(" 2021, 20452"), is(numbers));
    }

    @Test
    public void returnLargestNumberFromQuery(){
        assertThat(queryProcessor.process("cdaba3f0:which of the following numbers is the largest: 156, 20"), containsString("156"));
    }

    @Test
    public void returnNumbersMultiplied(){
        assertThat(queryProcessor.process("what is 15 multiplied by 13"), containsString("195"));
    }

    @Test
    public void yearForPrimeMinister() throws Exception {
        assertThat(queryProcessor.process(" which year was Theresa May first elected as the Prime Minister of Great Britain"), containsString("2016"));
    }

    @Test
    public void returnJamesBondActor() {
        assertThat(queryProcessor.process("who played James Bond"), containsString("Sean Connery"));
    }

    @Test
    public void returnEiffelTowerCity(){
        assertThat(queryProcessor.process("which city is eiffel tower in"), containsString("Paris"));
    }


}
