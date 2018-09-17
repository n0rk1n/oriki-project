package cn.oriki.commons.util;

import java.util.Objects;

/**
 * 字符转换类
 *
 * @author oriki.wang
 */
public class StringConverts {

    // 全角和半角的转换---------------------------------------------------------------------------------------------------

    /**
     * 字符串中 全角 -> 半角
     *
     * @param s 可能含全角的 String
     * @return 转换后 String
     */
    public static String toSBC(String s) {
        if (Strings.isBlank(s)) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append('\u3000');
            } else if (c < '\177') {
                stringBuilder.append((char) (c + 65248));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 字符串中 半角 -> 全角
     *
     * @param s 可能含半角的String
     * @return 转换后 String
     */
    public static String toDBC(String s) {
        if (Strings.isBlank(s)) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '\u3000') {
                stringBuilder.append(' ');
            } else if (c > '\uFF00' && c < '\uFF5F') {
                stringBuilder.append((char) (c - 65248));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    // 数据库表结构名称和 Java 名称的转换-----------------------------------------------------------------------------------

    /**
     * 标准列名称的前缀
     */
    private static final String COLUMN_PREFIX = "";

    /**
     * 标准表名称的前缀
     */
    private static final String TABLE_PREFIX = "t_";

    /**
     * 表名转换为 Java 类名
     *
     * @param tableName 表名
     * @param prefix    表名的前缀
     * @return Java 的标准类名称（驼峰，且首字母大写）
     */
    public static String toJavaClassName(String tableName, String prefix) {
        if (Strings.isNotBlank(tableName)) {
            tableName = tableName.toLowerCase();
            // 去除常用前缀
            tableName = tableName.replaceFirst(prefix, "");

            String[] strings = tableName.split("_");
            if (1 == strings.length) {
                return firstLetterUpper(tableName);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (String string : strings) {
                    stringBuilder.append(firstLetterUpper(string));
                }
                return stringBuilder.toString();
            }
        }
        return tableName;
    }

    /**
     * 列名称转换为属性名称
     *
     * @param tableColumnName 标准列名称
     * @return 属性名称（驼峰式，首字母小写）
     */
    public static String toJavaFieldName(String tableColumnName) {
        return toJavaClassName(tableColumnName, COLUMN_PREFIX);
    }

    /**
     * 将 java 类名转换为 sql 表名
     *
     * @param javaClassName java 类名
     * @param prefix        添加前缀
     * @return sql 表名
     */
    public static String toSqlTableName(String javaClassName, String prefix) {
        return toSqlName(javaClassName, prefix);
    }

    /**
     * 将 java 的属性名称转换为 sql 列名
     *
     * @param javaFieldName java 的属性名称
     * @return sql 的列名
     */
    public static String toSqlColumnName(String javaFieldName) {
        return toSqlName(javaFieldName, COLUMN_PREFIX);
    }

    /**
     * 单词首字母大写（其余小写）
     * <p>
     * 如果为长度 1 的字母，则直接大写
     * <p>
     * 如果开头为数字的话，不变化
     *
     * @param string 单词
     * @return 首字母大写的单词
     */
    private static String firstLetterUpper(String string) {
        if (Objects.isNull(string)) {
            return null;
        }
        string = string.toUpperCase();
        if (string.length() == 1) {
            return string;
        } else {
            return string.charAt(0)
                    + string.substring(1, string.length()).toLowerCase();
        }
    }

    /**
     * 将 java 名称转换为下斜线拼接的 sql 格式字符串
     *
     * @param javaName java 名称（驼峰式）
     * @param prefix   前缀
     * @return sql 名称
     */
    private static String toSqlName(String javaName, String prefix) {
        StringBuilder stringBuilder = new StringBuilder();
        // 如有前缀进行拼接
        if (Strings.isNotBlank(prefix)) {
            stringBuilder.append(prefix);
        }

        char[] chars = javaName.toCharArray();
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                if (!prefix.equals(stringBuilder.toString())) {
                    stringBuilder.append("_");
                }
                stringBuilder.append((char) (aChar + 32));
            } else {
                stringBuilder.append(aChar);
            }
        }

        return stringBuilder.toString();
    }

}
