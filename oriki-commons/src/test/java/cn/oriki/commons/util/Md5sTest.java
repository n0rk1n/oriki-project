package cn.oriki.commons.util;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class Md5sTest {

    @Test
    public void getMd5() throws NoSuchAlgorithmException {
        String s = "oriki";
        String md5 = Md5s.getMd5(s);
        boolean b = "47BB38D91C0CE5F85BF145DBA5E4EAF0".equalsIgnoreCase(md5);
        assertTrue(b);

        String s1 = "";
        String md51 = Md5s.getMd5(s1);// 空字符串加密内容： d41d8cd98f00b204e9800998ecf8427e
        boolean b1 = "D41D8CD98F00B204E9800998ECF8427E".equalsIgnoreCase(md51);
        assertTrue(b1);

        /*String md52 = Md5s.getMd5(null);
        System.out.println(md52);*/
    }

}