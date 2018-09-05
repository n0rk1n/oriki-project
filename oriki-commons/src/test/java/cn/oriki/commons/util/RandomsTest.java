package cn.oriki.commons.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomsTest {

    @Test
    public void getRandomNumber() {
        String randomNumber = Randoms.getRandomNumber(4);
        System.out.println(randomNumber);
    }

    @Test
    public void getCode() {
        String code = Randoms.getCode(4);
        System.out.println(code);
    }

    @Test
    public void getUuid() {
        String uuid = Randoms.getUuid();
        System.out.println(uuid);
    }

    @Test
    public void randomInt() {
        int i = Randoms.randomInt(10);
        System.out.println(i);
    }

}