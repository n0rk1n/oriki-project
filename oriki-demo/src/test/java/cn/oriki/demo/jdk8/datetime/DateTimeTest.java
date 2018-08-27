package cn.oriki.demo.jdk8.datetime;

import cn.oriki.commons.util.DateTimes;
import cn.oriki.commons.util.Dates;
import cn.oriki.commons.util.Times;
import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeTest {

    @Test
    public void test() {
        // 获取当前日期
        LocalDate now = Dates.now();
        System.out.println("today is : " + now);
    }

    @Test
    public void test1() {
        // 获取当前的年\月\日
        LocalDate today = Dates.now();

        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
    }

    @Test
    public void test2() {
        // 获取某个特定的日期
        LocalDate localDate = Dates.of(2008, 1, 1);
        System.out.println("date is : " + localDate);
    }

    // 在Java 8 检查两个日期是否相等 , 使用 equals ，不演示

    @Test
    public void test3() {
        // 检查重复事件，比如生日
        // 与时间日期相关的实际任务 -- 检查重复事件
        LocalDate birthday = Dates.of(1993, 8, 4);
        LocalDate now = Dates.now();

        boolean anniversary = Dates.isAnniversary(birthday, now);

        if (anniversary) {
            System.out.println("is birthday");
        } else {
            System.out.println("is not birthday");
        }
    }

    @Test
    public void test4() {
        // 获取当前时间
        LocalTime time = Times.now();
        System.out.println("local time now : " + time); // 19:02:26.736
        // 默认的格式是 hh:mm:ss:nnn ，这里的 nnn 是纳秒。
    }

    @Test
    public void test5() {
        // 增加时间里面的小时数
        LocalTime time = Times.now();
        System.out.println("local time now : " + time);
        LocalTime after = time.plusHours(2);
        System.out.println("after 2 hour :" + after);
    }

    @Test
    public void test6() {
        // 获取 1 周后的日期
        LocalDate now = Dates.now();
        // Java API中的 ChronoUnit 类可获取更多选项
        LocalDate plus = Dates.plus(now, 1L, ChronoUnit.WEEKS);
        System.out.println(plus);
    }
    // 减少 1 年，可以使用 minus 方法

    @Test
    public void test7() {
        // 使用时钟
        // 格林威治时钟
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        // 本地时钟
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println("Clock : " + clock1);
    }

    @Test
    public void test8() throws InterruptedException {
        // 获取 格林威治时间
        Clock clock = Clock.systemUTC();
        LocalDateTime time = LocalDateTime.now(clock);
        System.out.println(time);
    }

    @Test
    public void test9() {
        // 处理不同的时区
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now();
        // 针对本地时区，获取对应时区的 LocalDatetime
        ZonedDateTime dateTimeInNewYork = ZonedDateTime.of(localDateTime, america);
        System.out.println("Current date and time : " + dateTimeInNewYork);
    }

    @Test
    public void test10() {
        // 表示固定的日期，比如信用卡过期时间，可以使用 YearMonth 类
        // 模拟信用卡过期判断
        YearMonth credit = YearMonth.of(2020, Month.MAY);// 或者书写月份也可以
        YearMonth now = YearMonth.now();

        if (now.isAfter(credit)) {
            System.out.println("你的信用卡已过期");
        } else {
            System.out.println("你的信用卡未过期");
        }
    }

    @Test
    public void test11() {
        // 检查闰年
        boolean leapYear = Dates.isLeapYear(2018);
        System.out.println("是否为闰年：" + leapYear);
    }

    @Test
    public void test12() {
        // 两个日期之间包含多少天，多少个月
        LocalDate yearOf2008 = LocalDate.of(2008, 8, 8);
        LocalDate yearOf2018 = LocalDate.of(2018, 10, 2);

        Period between = Period.between(yearOf2008, yearOf2018);

        // TODO 比较迷
        System.out.println("日期差：" + between.getDays()); // 日期差：24
        System.out.println("月份差：" + between.getMonths()); // 月份差：1
        System.out.println("年份差：" + between.getYears()); // 年份差：10
    }

    @Test
    public void test13() {
        // ZoneOffset 类来代表某个时区，
        // 比如印度是 GMT 或者 UTC5：30 ，
        // 你可以使用它的静态方法 ZoneOffset.of() 方法来获取对应的时区。
        LocalDateTime datetime = LocalDateTime.of(2018, 1, 14, 19, 30);

        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println(date);
        // OffSetDateTime 主要是给机器来理解的，如果是给人看的，可以使用 ZoneDateTime 类。
    }

    @Test
    public void test14() {
        // 获取当前时间戳
        Instant timestamp = DateTimes.getInstant();
        System.out.println("instant :" + timestamp);

        // 当前时间戳是包含日期与时间的，与 java.util.Date 很类似，
        // 事实上 Instant 就是Java 8前的 Date ，
        // 你可以使用这两个类中的方法来在这两个类型之间进行转换，
        // 比如 Date.from(Instant) 是用来将 Instant 转换成 java.util.Date 的，
        // 而 Date.toInstant() 是将Date转换成Instant的。
    }

    @Test
    public void test15() {
        // 时间和字符串的相互转换
        String s = "2008-08-08 00:00:00";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime parse = DateTimes.parse(s, pattern);
        System.out.println(parse);

        String format = DateTimes.format(parse, pattern);
        System.out.println(format);
    }

}
