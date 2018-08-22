package cn.oriki.commons.util;

import cn.oriki.commons.entity.Children;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonsTest {

    @Test
    public void toObject() {
        String json="{\"age\":18,\"name\":\"zhangsan\",\"salary\":10000.0,\"surname\":\"X.\"}";
        Children children = Jsons.toObject(json, Children.class);
        System.out.println(children);
    }

    @Test
    public void toJson() {
        Children children = new Children();
        children.setName("zhangsan");
        children.setAge(18);
        children.setSalary(10000.0D);
        children.setSurname("X.");

        String s = Jsons.toJson(children);
        System.out.println(s);
    }

}