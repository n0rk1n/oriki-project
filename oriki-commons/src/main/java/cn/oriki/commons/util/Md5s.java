package cn.oriki.commons.util;

import lombok.NonNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Md5 加密
 *
 * @author oriki.wang
 */
public class Md5s {

    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private Md5s() {
    }

    public static String getMd5(@NonNull String string) throws NoSuchAlgorithmException {
        return hexdigest(string.getBytes());
    }

    /**
     * 加密的方法
     *
     * @param bytes
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String hexdigest(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest e = MessageDigest.getInstance("MD5");
        e.update(bytes);
        byte[] tmp = e.digest();
        char[] str = new char[32];
        int k = 0;

        for (int i = 0; i < 16; ++i) {
            byte byte0 = tmp[i];
            str[k++] = hexDigits[byte0 >>> 4 & 15];
            str[k++] = hexDigits[byte0 & 15];
        }

        return new String(str);
    }

}
