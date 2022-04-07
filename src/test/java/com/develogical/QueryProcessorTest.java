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
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 64, 729, 30"), containsString("64, 729"));
    }
}
