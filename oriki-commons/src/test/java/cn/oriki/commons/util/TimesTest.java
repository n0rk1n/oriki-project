package cn.oriki.commons.util;

import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimesTest {

    @Test
    public void now() {
        LocalTime now = Times.now();
        System.out.println(now);
    }

    @Test
    public void plusHours() {
        LocalTime now = Times.now();
        LocalTime localTime = Times.plusHours(now, 1L);
        System.out.println(localTime);
    }

    @Test
    public void plus() {
        LocalTime now = Times.now();
        LocalTime plus = Times.plus(now, 1L, ChronoUnit.HOURS);
        System.out.println(plus);
    }

}