package cn.oriki.commons.util;

import cn.oriki.commons.entity.Children;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.*;

public class ReflectsTest {

    @Test
    public void getClassName() {
        String s = Reflects.getClassName(Object.class);
        assertEquals("Object", s);
    }

    @Test
    public void getPublicMethods() {
        List<Method> publicMethods = Reflects.getPublicMethods(Children.class);
        System.out.println(publicMethods.size());
        List<Method> publicMethods1 = Reflects.getPublicMethods(Object.class);
        System.out.println(publicMethods1.size());

        // 共有 4 个属性，8个公共方法。其中 Object 中提供了 9 个公共方法
        assertEquals(publicMethods.size(), publicMethods1.size() + 8);
    }

}