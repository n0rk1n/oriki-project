package cn.oriki.commons.util;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CollectionsTest {

    private List<String> list;
    private List<String> emptyList;

    public CollectionsTest() {
        this.list = Lists.newArrayList();
        this.emptyList = Lists.newArrayList();

        list.add("1");
    }

    @Test
    public void nonNullAndHasElements() {
        boolean b = Collections.nonNullAndHasElements(list);
        assertTrue(b);

        boolean b1 = Collections.nonNullAndHasElements(emptyList);
        assertFalse(b1);
    }

    @Test
    public void isNullOrNoElement() {
        boolean b = Collections.isNullOrNoElement(list);
        assertFalse(b);

        boolean b1 = Collections.isNullOrNoElement(emptyList);
        assertTrue(b1);

        boolean b2 = Collections.isNullOrNoElement(null);
        assertTrue(b2);
    }

    @Test
    public void join() {
        String join = Collections.join(list, ",");
        System.out.println(join);

        String join1 = Collections.join(emptyList, ",");
        System.out.println(join1);

        List<String> list1 = Lists.newArrayList();
        list1.add("1");
        list1.add(null);
        list1.add("2");
        String join2 = Collections.join(list1, ",");
        System.out.println(join2);
    }

    @Test
    public void isCollection() {
        boolean b = Collections.isCollection(new Object());
        assertFalse(b);

        boolean b1 = Collections.isCollection(Lists.newArrayList());
        assertTrue(b1);
    }

    @Test
    public void nCopies() {
        List<String> b = Collections.nCopies(4, "b");
        assertEquals(4, b.size());
    }

}