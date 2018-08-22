package cn.oriki.commons.util;

import lombok.NonNull;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;

/**
 * 日期工具类
 *
 * @author oriki
 */
public class Dates {

    /**
     * 获取当天日期对象
     *
     * @return LocalDate 对象
     */
    public static LocalDate now() {
        return LocalDate.now();
    }

    /**
     * 指定年月日 获取 LocalDate 对象
     *
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @return LocalDate 对象
     */
    public static LocalDate of(int year, int month, int dayOfMonth) {
        return LocalDate.of(year, month, dayOfMonth);
    }

    /**
     * 判断今天是否为指定日期的周年纪念日
     *
     * @param localDate 目标日期
     * @return 今天是否为指定日期的周年纪念日
     */
    public static boolean isTodayAnniversary(@NonNull LocalDate localDate) {
        LocalDate today = LocalDate.now();
        LocalDate of = LocalDate.of(today.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
        return isAnniversary(of, today);
    }

    /**
     * 判断指定日期是否为周年纪念日，用于判定类似生日，特定节日的方法
     *
     * @param targetLocalDate 目标日期
     * @param localDate       制定日期
     * @return 是否为目标日期的周年纪念日
     */
    public static boolean isAnniversary(@NonNull LocalDate targetLocalDate, @NonNull LocalDate localDate) {
        MonthDay target = MonthDay.of(targetLocalDate.getMonth(), targetLocalDate.getDayOfMonth());
        MonthDay monthDay = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        return target.equals(monthDay);
    }

    /**
     * 推进/后退 指定星期
     *
     * @param localDate LocalDate 对象
     * @param number    周数
     * @return LocalDate 对象
     */
    public static LocalDate plusWeeks(@NonNull LocalDate localDate, long number) {
        return plus(localDate, number, ChronoUnit.WEEKS);
    }

    /**
     * 推进/后退 特定时间
     *
     * @param localDate  LocalDate 对象
     * @param number     数量
     * @param chronoUnit 时间单位枚举
     * @return LocalDate 对象
     */
    public static LocalDate plus(@NonNull LocalDate localDate, long number, ChronoUnit chronoUnit) {
        return localDate.plus(number, chronoUnit);
    }

    /**
     * 判断一个年份是否为闰年
     *
     * @param year 年份
     * @return 是否为闰年，闰年返回 true ，否则返回false
     */
    public static boolean isLeapYear(int year) {
        LocalDate localDate = LocalDate.of(year, 1, 1);
        return localDate.isLeapYear();
    }

}