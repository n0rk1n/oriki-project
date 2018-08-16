package cn.oriki.commons.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void testIsBlank() {
        String s = "";
        String s1 = null;
        String s2 = "abcd";
        String s3 = " ";

        boolean b = Strings.isBlank(s);
        boolean b1 = Strings.isBlank(s1);
        boolean b2 = Strings.isBlank(s2);
        boolean b3 = Strings.isBlank(s3);

        assertTrue(b);
        assertTrue(b1);
        assertFalse(b2);
        assertTrue(b3);
    }

    @Test
    public void isNotBlank() {
        String s = "";
        String s1 = null;
        String s2 = "abcd";
        String s3 = " ";

        boolean b = Strings.isNotBlank(s);
        boolean b1 = Strings.isNotBlank(s1);
        boolean b2 = Strings.isNotBlank(s2);
        boolean b3 = Strings.isNotBlank(s3);

        assertFalse(b);
        assertFalse(b1);
        assertTrue(b2);
        assertFalse(b3);
    }

    @Test
    public void isContain() {
        String string = "abcde";
        String s = "a";
        String s1 = "bcd";
        String s2 = "def";

        boolean b = Strings.isContain(string, s);
        boolean b1 = Strings.isContain(string, s1);
        boolean b2 = Strings.isContain(string, s2);

        assertTrue(b);
        assertTrue(b1);
        assertFalse(b2);
    }

}