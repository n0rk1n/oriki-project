package cn.oriki.commons.util;

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
        for (char aChar : s.toCharArray()) {
            if (aChar == '\u3000') {
                stringBuilder.append(' ');
            } else if (aChar > '\uFF00' && aChar < '\uFF5F') {
                stringBuilder.append((char) (aChar - 65248));
            } else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }

}
