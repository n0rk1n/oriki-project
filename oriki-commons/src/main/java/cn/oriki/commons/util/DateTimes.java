package cn.oriki.commons.util;

import lombok.NonNull;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 日期、时间工具类
 *
 * @author oriki
 */
public class DateTimes {

    private static final String NORMAL_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String NORMAL_DATE_PATTERN = "yyyy-MM-dd";
    private static final String NORMAL_TIME_PATTERN = "HH:mm:ss";

    /**
     * 获取本地当前时间 LocalDateTime 对象
     *
     * @return 当前时间 LocalDateTime 对象
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * 判断 t1 是否在 t2 之前
     *
     * @param t1 LocalDateTime t1 对象
     * @param t2 LocalDateTime t2 对象
     * @return t1 在 t2 之前，返回 true
     */
    public static boolean isBefore(@NonNull LocalDateTime t1, @NonNull LocalDateTime t2) {
        return t1.isBefore(t2);
    }

    /**
     * 判断 t1 是否在 t2 之后
     *
     * @param t1 LocalDateTime t1 对象
     * @param t2 LocalDateTime t2 对象
     * @return t1 在 t2 之后，返回 true
     */
    public static boolean isAfter(@NonNull LocalDateTime t1, @NonNull LocalDateTime t2) {
        return t1.isAfter(t2);
    }

    /**
     * 获取两时间的时间差，单位为毫秒
     *
     * @param before 之前时间对象
     * @param after  之后时间对象
     * @return 两个时间的毫秒差值
     */
    public static long diffMillis(@NonNull LocalDateTime before, @NonNull LocalDateTime after) {
        Duration duration = Duration.between(before, after);
        // TODO 如果有特殊需求，可以修改 Duration 的 toX 方法
        return duration.toMillis();
    }

    /**
     * 获取两个时间差，填入时间为之前的时间，与调用该方法的时刻作比较，单位为毫秒值
     *
     * @param before
     * @return
     */
    public static long diffMillisWithNow(@NonNull LocalDateTime before) {
        return diffMillis(before, now());
    }

    /**
     * 推进（后退） hours 小时
     * <p>
     * TODO 可以按照需求定制
     * <p>
     * 链式结构
     *
     * @param localDateTime 目标对象
     * @param hours         延后的时间（小时）
     * @return 目标对象延后后后的对象
     */
    public static LocalDateTime addHours(@NonNull LocalDateTime localDateTime, long hours) {
        return add(localDateTime, hours, ChronoUnit.HOURS);
    }

    /**
     * 按照特定 Unit 进行时间推进或后退
     *
     * @param localDateTime LocalDateTime 对象
     * @param number        改变数值
     * @param chronoUnit    Unit 类别
     * @return 推进或后退的 LocalDateTime 对象
     */
    public static LocalDateTime add(@NonNull LocalDateTime localDateTime, long number, ChronoUnit chronoUnit) {
        return localDateTime.plus(number, chronoUnit);
    }

    /**
     * 以 yyyy-MM-dd HH:mm:ss 格式化 LocalDateTime 对象
     *
     * @param localDateTime LocalDateTime 对象
     * @return 时间字符串
     */
    public static String formatNormalDateTime(@NonNull LocalDateTime localDateTime) {
        return format(localDateTime, NORMAL_DATETIME_PATTERN);
    }

    /**
     * 以 yyyy-MM-dd 格式化 LocalDateTime 对象
     *
     * @param localDateTime LocalDateTime 对象
     * @return yyyy-MM-dd 格式字符串
     */
    public static String formatNormalDate(@NonNull LocalDateTime localDateTime) {
        return format(localDateTime, NORMAL_DATE_PATTERN);
    }

    /**
     * 以 HH:mm:ss 格式化 LocalDateTime 对象
     *
     * @param localDateTime LocalDateTime 对象
     * @return HH:mm:ss 格式字符串
     */
    public static String formatNormalTime(@NonNull LocalDateTime localDateTime) {
        return format(localDateTime, NORMAL_TIME_PATTERN);
    }

    /**
     * 特定 pattern 格式化 LocalDateTime 对象
     *
     * @param localDateTime LocalDateTime 对象
     * @param pattern       时间格式化字符串
     * @return 时间字符串
     */
    public static String format(@NonNull LocalDateTime localDateTime, @NonNull String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 解析 时间格式字符串 按照特定 pattern 为 LocalDateTime 对象
     * <p>
     * TODO 使用 JDK 方法，针对只到日期的情况不能很好处理，所以请保证 含有日期和时间格式，如果不可以，请使用 DateFormat 子类
     *
     * @param dateTimeString 时间格式字符串
     * @param pattern        pattern 特定格式 pattern
     * @return LocalDateTime 对象
     */
    public static LocalDateTime parse(@NonNull String dateTimeString, @NonNull String pattern) {
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间的时间戳
     *
     * @return
     */
    public static Instant getInstant() {
        return Instant.now();
    }

    /**
     * Instant 时间戳 转换为 Date 类型
     *
     * @param instant 时间戳
     * @return Date
     */
    public static Date instantToDate(@NonNull Instant instant) {
        return Date.from(instant);
    }

}
