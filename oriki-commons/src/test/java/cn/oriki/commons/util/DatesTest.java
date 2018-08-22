package cn.oriki.commons.util;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class DatesTest {

    @Test
    public void now() {
        LocalDate now = Dates.now();
        LocalDate now1 = LocalDate.now();
        assertEquals(now, now1);
    }

    @Test
    public void of() {
        LocalDate now = Dates.now();
        LocalDate of = Dates.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        assertEquals(now, of);
    }

    @Test
    public void isTodayAnniversary() {
        LocalDate now = Dates.now();
        LocalDate of = Dates.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        boolean todayAnniversary = Dates.isTodayAnniversary(of);
        assertTrue(todayAnniversary);
    }

    @Test
    public void isAnniversary() {
        LocalDate now = Dates.now();
        LocalDate of = Dates.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth());

        boolean anniversary = Dates.isAnniversary(now, of);
        assertTrue(anniversary);

        LocalDate localDate = of.plusWeeks(1L);
        boolean anniversary1 = Dates.isAnniversary(now, localDate);
        assertFalse(anniversary1);
    }

    @Test
    public void isLeapYear() {
        boolean leapYear = Dates.isLeapYear(2018);
        assertFalse(leapYear);
    }

    @Test
    public void plusWeeks() {
        LocalDate localDate = Dates.plusWeeks(Dates.now(), 1L);
        assertEquals(Dates.now().plusWeeks(1L), localDate);
    }

    @Test
    public void plus() {
        LocalDate now = Dates.now();
        LocalDate plus = Dates.plus(now, 1L, ChronoUnit.WEEKS);
        assertEquals(Dates.plusWeeks(now, 1L), plus);
    }

}