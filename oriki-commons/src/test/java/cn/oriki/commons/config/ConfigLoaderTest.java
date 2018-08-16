package cn.oriki.commons.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigLoaderTest {

    private ConfigLoader configLoader;

    @Before
    public void before() {
        configLoader = new ConfigLoader("test1.properties", "test2.properties");
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull(configLoader);
    }

    @Test
    public void testGetConfigs() {
        Assert.assertEquals(4, configLoader.getConfigs().size());
    }

    @Test
    public void testGetConfigs1() {
        ConfigLoader configLoader = new ConfigLoader("test1.properties", "test3.properties");
        Assert.assertEquals(2, configLoader.getConfigs().size());
    }

    @Test
    public void testClear() {
        boolean b = configLoader.clear();
        Assert.assertTrue(b);
    }

    @Test
    public void testGetProperties() {
        String value1 = configLoader.getProperties("key1");
        Assert.assertEquals("value1", value1);

        String unknownValue = configLoader.getProperties("unknownKey");
        Assert.assertNull(unknownValue);
    }

    @Test
    public void getGetProperties() {
        String value = configLoader.getProperties("key1", "defaultValue");
        Assert.assertEquals("value1", value);

        String unknownValue = configLoader.getProperties("unknownKey", "defaultValue");
        Assert.assertEquals(unknownValue, "defaultValue");
    }

    @Test
    public void testGetBoolean() {
        Boolean value = configLoader.getBoolean("key1");
        Assert.assertNull(value);

        Boolean unknownKey = configLoader.getBoolean("unknownKey");
        Assert.assertNull(unknownKey);
    }

    @Test
    public void testGetBoolean1() {
        Boolean b = new ConfigLoader("test4.properties").getBoolean("boolean-key");
        Assert.assertTrue(b);
    }

    @Test
    public void testGetBoolean2() {
        boolean b = new ConfigLoader("test4.properties").getBoolean("boolean-key", false);
        Assert.assertTrue(b);

        boolean b1 = new ConfigLoader("test4.properties").getBoolean("unknown-key", false);
        Assert.assertFalse(b1);
    }

}