package cn.oriki.commons.util;

import lombok.NonNull;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * 时间工具类
 *
 * @author oriki
 */
public class Times {

    /**
     * 获取一个不包含日期的时间对象
     * <p>
     * 默认的格式是 hh:mm:ss:nnn ， nnn 为纳秒。
     *
     * @return LocalTime 对象
     */
    public static LocalTime now() {
        return LocalTime.now();
    }

    /**
     * 推进/缩减 指定小时
     *
     * @param localTime LocalTime 对象
     * @param number    小时数
     * @return LocalTime 对象
     */
    public static LocalTime plusHours(@NonNull LocalTime localTime, long number) {
        return plus(localTime, number, ChronoUnit.HOURS);
    }

    /**
     * 推进/缩减 指定时间
     *
     * @param localTime  LocalTime 对象
     * @param number     推荐时间
     * @param chronoUnit 时间单位
     * @return LocalTime 对象
     */
    public static LocalTime plus(@NonNull LocalTime localTime, long number, ChronoUnit chronoUnit) {
        // TODO 使用 ChronoUnit 超过小时的级别 会抛出 UnsupportedTemporalTypeException
        return localTime.plus(number, chronoUnit);
    }

}