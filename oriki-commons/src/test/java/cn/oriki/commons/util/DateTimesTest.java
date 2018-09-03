package cn.oriki.commons.util;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.Assert.*;

public class DateTimesTest {

    @Test
    public void now() {
        LocalDateTime now = DateTimes.now();
        System.out.println(now);
    }

    @Test
    public void isBefore() throws InterruptedException {
        LocalDateTime before = DateTimes.now();
        Thread.sleep(1L);
        LocalDateTime after = DateTimes.now();
        boolean b = DateTimes.isBefore(before, after);
        assertTrue(b);
    }

    @Test
    public void isAfter() throws InterruptedException {
        LocalDateTime before = DateTimes.now();
        Thread.sleep(2L);
        LocalDateTime after = DateTimes.now();
        boolean b = DateTimes.isAfter(before, after);
        assertFalse(b);
    }

    @Test
    public void diffMillis() throws InterruptedException {
        LocalDateTime before = DateTimes.now();
        Thread.sleep(2L);
        LocalDateTime after = DateTimes.now();
        long l = DateTimes.diffMillis(before, after);
        System.out.println(l);
    }

    @Test
    public void diffMillisWithNow() throws InterruptedException {
        LocalDateTime before = DateTimes.now();
        Thread.sleep(2L);
        long l = DateTimes.diffMillisWithNow(before);
        System.out.println(l);
    }

    @Test
    public void addHours() {
        LocalDateTime before = DateTimes.now();
        LocalDateTime after = DateTimes.addHours(before, 2L);
        System.out.println(after);
    }

    @Test
    public void add() {
        LocalDateTime now = DateTimes.now();
        LocalDateTime after = DateTimes.add(now, -2, ChronoUnit.DAYS);
        System.out.println(after);
    }

    @Test
    public void formatNormalDateTime() {
        String s = DateTimes.formatNormalDateTime(DateTimes.now());
        System.out.println(s);
    }

    @Test
    public void formatNormalDate() {
        String s = DateTimes.formatNormalDate(DateTimes.now());
        System.out.println(s);
    }

    @Test
    public void formatNormalTime() {
        String s = DateTimes.formatNormalTime(DateTimes.now());
        System.out.println(s);
    }

    @Test
    public void format() {
        String s = DateTimes.format(DateTimes.now(), "yyyy-MM");
        System.out.println(s);
    }

    @Test
    public void parse() {
        LocalDateTime parse = DateTimes.parse("2018-08-08 00:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println(parse);
    }

    @Test
    public void getInstant() {
        Instant instant = DateTimes.getInstant();
        System.out.println(instant);
    }

    @Test
    public void instantToDate() {
        Date date = DateTimes.instantToDate(DateTimes.getInstant());
        System.out.println(date);
    }

    @Test
    public void dateToInstant() {
        Date date = new Date();
        Instant instant = DateTimes.dateToInstant(date);
        System.out.println(instant);
    }

}