package cn.oriki.commons.util;

import com.google.common.collect.Lists;
import lombok.NonNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
     * 获取字节码文件的所有 public method（包含父类 & Object）
     * <p>
     * 没有公开方法会返回空集合
     *
     * @param clazz 字节码文件
     * @return Class 对象中所有权限为 public 方法的对象
     */
    public static List<Method> getPublicMethods(@NonNull Class<?> clazz) {
        return Lists.newArrayList(clazz.getMethods());
    }

    /**
     * 获取字节码文件的所有 public 方法，并剔除 Object 提供的公开方法
     *
     * @param clazz 字节码文件
     * @return 剔除了 Object 中的公开方法的其余方法
     */
    public static List<Method> getPublicMethodsWithoutObject(@NonNull Class<?> clazz) {
        List<Method> publicMethods = getPublicMethods(clazz);
        List<Method> objectMethod = getPublicMethods(Object.class);
        publicMethods.removeAll(objectMethod);
        return publicMethods;
    }

    /**
     * 获取字节码文件的所有 field (包含父类)
     * <p>
     * 没有属性会返回空集合
     *
     * @param clazz 字节码文件
     * @return 对象中所有成员变量
     */
    public static List<Field> getFields(@NonNull Class<?> clazz) {
        // 递归获取父类 Field
        return getFields(Lists.newArrayList(), clazz);
    }

    /**
     * 递归，获取 Class 本身及其父类中成员变量
     *
     * @param list  存储集合
     * @param clazz Class 对象
     * @param <T>   泛型
     * @return 存储集合
     */
    private static <T> List<Field> getFields(@NonNull List<Field> list, Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        // 存入本字节码文件所有 Field
        if (fields != null && fields.length > 0) {
            list.addAll(Arrays.asList(fields));
        }
        Class<? super T> superclass = clazz.getSuperclass();
        if (Objects.nonNull(superclass) && !Object.class.equals(superclass)) {
            getFields(list, superclass);
        }
        return list;
    }

}
