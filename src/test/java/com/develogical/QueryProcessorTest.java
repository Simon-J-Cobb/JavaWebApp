package com.develogical;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

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
    public void returnLargestNumber() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(2021);
        numbers.add(20452);
        assertThat(queryProcessor.largestNumberFrom(numbers), is(20452));
    }

    @Test
    public void stringToNumbers(){
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(2021);
        numbers.add(20452);
        assertThat(queryProcessor.stringToNumbers(" 2021, 20452"), is(numbers));
    }
}
