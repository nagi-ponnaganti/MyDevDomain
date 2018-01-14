package com.nagihome.regex;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(JUnit4.class)
public class RegexTests {

    @Test
    public void testDigitPattern() {
        Assert.assertTrue("21.5".matches("^\\d+(\\.\\d)?"));
    }

    @Test
    public void testMatchAnyChar() {
        Assert.assertTrue("%".matches("."));
    }

    @Test
    public void testStartsWithDigit() {
        Assert.assertTrue("124ASD".matches("^\\d+[A-Z]+"));
    }

    @Test
    public void testEndsWithDigit() {
        Assert.assertTrue("ASDHF124".matches("[ASD]+[HF]+\\d+"));
    }

    @Test
    public void testWithSpecificChars() {
        Assert.assertTrue("aaaA1AA11".matches("[aA1]*"));
    }

    @Test
    public void testWithCaret() {
        Assert.assertTrue("123efg".matches("[^abc]+"));
    }

    @Test
    public void testWithRangeCharAndNum() {
        Assert.assertTrue("abc123".matches("[a-c1-3]+"));
    }

    @Test
    public void testWithFindsPattern() {
        Assert.assertTrue("a".matches("a|b"));
    }

    @Test
    public void testAnyDigitPattern() {
        Assert.assertTrue("4".matches("\\d"));
        Assert.assertTrue("432".matches("[0-9]+"));
    }

    @Test
    public void testAnyNonDigitPattern() {
        Assert.assertTrue("asdf".matches("[^0-9]+"));
        Assert.assertTrue("asdf".matches("\\D+"));
    }

    @Test
    public void testWhiteSpacePattern() {
        Assert.assertTrue("  ".matches("\\s+"));
    }

    @Test
    public void testNonWhiteSpacePattern() {
        Assert.assertTrue("1234".matches("\\S+"));
    }

    @Test
    public void testWordPattern() {
        Assert.assertTrue("Hello World".matches("\\w+\\s\\w+"));
    }

/*    @Test // Not Working, TODO
    public void testNonWordPattern() {
        Assert.assertTrue("Some Special Chars: !\"£$%^&*()_+".matches("(\\w\\s)+\\S+\\s\\W+"));
    }*/

    @Test
    public void testZeroOrMoreTimesPattern() {
        Assert.assertTrue("".matches("A*"));
        Assert.assertTrue("AAA".matches("A*"));
        Assert.assertTrue("AB123DE".matches(".*"));
    }

    @Test
    public void testOneOrMoreTimesPattern() {
        Assert.assertTrue("AAA".matches("A+"));
        Assert.assertFalse("".matches("A+"));
    }

    @Test
    public void testNoOrMoreTimesPattern() {
        Assert.assertFalse("AAA".matches("A?"));
        Assert.assertTrue("AB".matches("A?B "));
    }

    @Test
    public void testXNumberOfTimes() {
        Assert.assertTrue("AAAA".matches("A{4}"));
    }

    @Test
    public void testOccursBetweenTimes() {
        Assert.assertTrue("AAAA".matches("A{1,4}"));
        Assert.assertFalse("AAAAA".matches("A{1,4}"));
    }

    public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

    @Test
    public void testWordMatches() {
        Assert.assertTrue(EXAMPLE_TEST.matches("\\w.*"));
    }

    @Test
    public void testSplitMethod() {
        Assert.assertTrue(EXAMPLE_TEST.split("\\s+").length == 14);
    }

    @Test
    public void testReplaceAllPattern() {
        Assert.assertTrue(EXAMPLE_TEST.replaceAll("\\s", "\t").matches("\\w.*"));
    }

    @Test
    public void testStringMatches() {
        Assert.assertTrue("True".matches("[Tt]rue"));
        Assert.assertTrue("true".matches("[Tt]rue"));
        Assert.assertTrue("Yes".matches("[tT]rue|[yY]es"));
        Assert.assertTrue("Yes".matches(".*Yes.*"));
        Assert.assertTrue("ABC123".matches("[a-zA-Z0-9]{6}"));
        Assert.assertTrue("123ABC".matches("^[^\\d].*"));
    }

    @Test
    public void testPatternAndMatcher() {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
        Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
        System.out.println(matcher2.replaceAll("\t"));

        pattern = Pattern.compile("\\d{3}");
        matcher = pattern.matcher("99900234");
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
    }
}
