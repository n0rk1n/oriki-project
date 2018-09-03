package cn.oriki.commons.response;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponsesTest {

    @Test
    public void responseSuccess() {
        String s = Responses.responseSuccess(new Object());
        System.out.println(s);
    }

    @Test
    public void responseException() {
        String s = Responses.responseException(new RuntimeException("has error"));
        System.out.println(s);
    }

}