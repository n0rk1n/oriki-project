package cn.oriki.commons.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringConvertsTest {

    @Test
    public void toSBC() {
    }

    @Test
    public void toDBC() {
    }

    @Test
    public void toJavaClassName() {
        String s = StringConverts.toJavaClassName("t_user_information", "t_");
        assertEquals("UserInformation", s);
    }

    @Test
    public void toJavaFieldName() {
        String userName = StringConverts.toJavaFieldName("user_name");
        assertEquals("UserName", userName);
    }

    @Test
    public void toSqlTableName() {
        String s = StringConverts.toSqlTableName("UserInformation", "t_");
        assertEquals("t_user_information", s);
    }

    @Test
    public void toSqlColumnName() {
        String userName = StringConverts.toSqlColumnName("userName");
        assertEquals("user_name", userName);
    }

}