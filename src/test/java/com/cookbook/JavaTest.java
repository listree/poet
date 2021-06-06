package com.cookbook;

import org.junit.Assert;
import org.junit.Test;
import java.util.function.Function;

public class JavaTest {

    @Test
    public void testFunctions() throws Exception {

        Function<String, String> capitalize = val -> val.toUpperCase();
        Assert.assertTrue(capitalize.apply("Poet").equals("POET"));
        Assert.assertTrue(capitalize.apply("Write").equals("WRITE"));
        Assert.assertTrue(capitalize.apply("Code").equals("CODE"));

        Function<String, Integer> length = val -> val.length();
        Assert.assertTrue(length.apply("Poet") == 4);
        Assert.assertTrue(length.apply("Write") ==5);
        Assert.assertTrue(length.apply("Code") == 4);

    }

    @Test
    public void testAndThen() throws Exception {

        Function<String, String> capitalize = val -> val.toUpperCase();
        Function<String, String> length = val -> val + ":" + val.length();
        Assert.assertTrue(capitalize.andThen(length).apply("Poet").equals("POET:4"));
        Assert.assertTrue(capitalize.andThen(length).apply("Write").equals("WRITE:5"));
        Assert.assertTrue(capitalize.andThen(length).apply("Code").equals("CODE:4"));

    }

    @Test
    public void testCompose() throws Exception {

        Function<String, String> capitalize = val -> val.toUpperCase();
        Function<String, String> length = val -> val + ":" + val.length();
        Assert.assertTrue(capitalize.compose(length).apply("Poet").equals("POET:4"));
        Assert.assertTrue(capitalize.compose(length).apply("Write").equals("WRITE:5"));
        Assert.assertTrue(capitalize.compose(length).apply("Code").equals("CODE:4"));

    }

}
