package cn.oriki.commons.util;

import java.util.*;

/**
 * Collections
 *
 * @author oriki
 */
public class Collections {

    /**
     * 集合不为空并且存在数据返回 true
     *
     * @param collection 集合
     * @return 集合不为空并且存在数据的情况返回 true
     */
    public static boolean nonNullAndHasElements(Collection<?> collection) {
        return !isNullOrNoElement(collection);
    }

    /**
     * 集合为空 或者 集合没有数据返回 true
     *
     * @param collection 集合
     * @return 集合为空或者不存在数据返回 true
     */
    public static boolean isNullOrNoElement(Collection<?> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    /**
     * Collection 根据 separator 进行拼接，生成字符串
     *
     * @param collection Collection 对象
     * @param separator  分隔符
     * @return 拼接后字符串
     */
    public static String join(Collection<?> collection, String separator) {
        if (Objects.isNull(collection)) {
            // 不存在映射返回空字符串
            return Strings.EMPTY_STRING;
        } else {
            Iterator<?> iterator = collection.iterator();
            if (!iterator.hasNext()) {
                return Strings.EMPTY_STRING;
            } else {
                Object first = iterator.next();
                if (!iterator.hasNext()) {
                    return Objects.isNull(first) ? Strings.EMPTY_STRING : first.toString();
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (Objects.nonNull(first)) {
                        stringBuilder.append(first);
                    }

                    while (iterator.hasNext()) {
                        Object obj = iterator.next();
                        if (Objects.isNull(obj)) {
                            continue;
                        }

                        if (Objects.nonNull(separator)) {
                            stringBuilder.append(separator);
                        }
                        stringBuilder.append(obj.toString());
                    }
                    return stringBuilder.toString();
                }
            }
        }
    }

    /**
     * Collection 根据 separator 进行拼接，生成字符串
     *
     * @param collection 集合
     * @param separator  分隔符
     * @param prefix     前缀字符串
     * @param suffix     后缀字符串
     * @return 拼接后的字符串
     */
    public static String join(Collection<?> collection, String separator, String prefix, String suffix) {
        return prefix + join(collection, separator) + suffix;
    }

    /**
     * 判断对象是否为集合或者为枚举集（备用）
     *
     * @param e 待判断对象
     * @return 如果是集合子类，返回 true
     */
    public static <E> boolean isCollection(E e) {
        return e instanceof Iterable || e instanceof Enumeration;
    }

    /**
     * 创建一个长度为 n 的集合，填充 o 对象
     * <p>
     * 实际调用的是 java.util.Collection 的 nCopy 方法
     *
     * @param n      集合长度
     * @param object 填充对象
     * @param <T>    泛型
     * @return 填充 o 对象的集合
     */
    public static <T> List<T> nCopies(int n, T object) {
        return java.util.Collections.nCopies(n, object);
    }

}
