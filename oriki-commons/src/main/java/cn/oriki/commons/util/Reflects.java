package cn.oriki.commons.util;

import com.google.common.collect.Lists;
import lombok.NonNull;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 反射工具类
 *
 * @author oriki.wang
 */
public class Reflects {

    /**
     * 全路径分隔符
     */
    private static final String CLASS_PATH_SEPARATOR = "\\.";

    /**
     * 截取字节码文件的类名（如 java.lang.Object ， 截取获得 Object）
     *
     * @param clazz 字节码文件
     * @return Class 类名
     */
    public static String getClassName(@NonNull Class<?> clazz) {
        String[] split = clazz.getName().split(CLASS_PATH_SEPARATOR);
        return split[split.length - 1];
    }

    /**
     * 获取字节码文件的所有 public method（包含父类）
     *
     * @param clazz 字节码文件
     * @return Class 对象中所有权限为 public 方法的对象
     */
    public static List<Method> getPublicMethods(@NonNull Class<?> clazz) {
        return Lists.newArrayList(clazz.getMethods());
    }

}
