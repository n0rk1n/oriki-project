package cn.oriki.commons.config;

import com.google.common.collect.Maps;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 配置文件加载器
 * <p>
 * ConfigLoader 可以加载多个配置文件，加载的配置文件都可以在 ConfigLoader 中通过 getX 方法读取
 * <p>
 * 如果两个配置文件中存在同名的键，后加载的会覆盖先前加载的值
 *
 * @author oriki
 */
public class ConfigLoader {

    /**
     * 配置文件读取
     */
    private Properties properties;

    /**
     * 加载器加载配置文件映射
     */
    private Map<String, String> parameters;

    /**
     * 构造函数
     *
     * @param configPaths 可变配置文件
     */
    public ConfigLoader(String... configPaths) {
        properties = new Properties();
        checkParameters();
        Arrays.stream(configPaths).forEach(this::init);
    }

    /**
     * 根据 key 获取 value ，如果不存在，返回 null
     *
     * @param key 键 key
     * @return 值 value ，如果不存在返回 null
     */
    public String getProperties(String key) {
        return this.parameters.get(key);
    }

    /**
     * 根据 key 获取 value ，如果不存在，返回 defaultValue
     *
     * @param key          键 key
     * @param defaultValue 默认值
     * @return 如果可以通过 key 获取 value ，如果不存在，返回 defaultValue
     */
    public String getProperties(String key, String defaultValue) {
        return this.parameters.getOrDefault(key, defaultValue);
    }

    /**
     * 根据 key 获取 value ，直接转换 boolean 类型。如果获取不到，返回 null
     *
     * @param key 键 key
     * @return 获取 key 转换为 boolean 类型，成功返回 boolean，失败或未获取到返回 null
     */
    public Boolean getBoolean(String key) {
        Boolean b = null;
        String s = getProperties(key);
        if (Objects.nonNull(s)) {
            if (Boolean.TRUE.toString().equals(s)) {
                b = Boolean.TRUE;
            } else if (Boolean.FALSE.toString().equals(s)) {
                b = Boolean.FALSE;
            }
        }
        return b;
    }

    /**
     * 根据 key 获取 value ，转换成 boolean 类型。如果获取不到，返回 defaultBoolean
     *
     * @param key            键 key
     * @param defaultBoolean 默认 boolean 类型
     * @return 获取并转换成功，返回 boolean 类型数据，没有则返回 defaultBoolean
     */
    public boolean getBoolean(String key, boolean defaultBoolean) {
        Boolean b = getBoolean(key);
        return Objects.nonNull(b) ? b : defaultBoolean;
    }

    /**
     * 获取所有配置文件映射
     *
     * @return 不可修改
     */
    public Map<String, String> getConfigs() {
        return Collections.unmodifiableMap(this.parameters);
    }

    /**
     * 清空映射中所有配置
     */
    public void clear() {
        this.parameters.clear();
    }

    /**
     * 根据配置文件地址加载配置信息
     *
     * @param configPath properties 配置文件地址
     */
    private void init(String configPath) {
        // 使用 JDK 7 特性
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configPath)) {
            this.properties.load(inputStream);
            this.properties.forEach((entryKey, entryValue) -> {
                String key = (String) entryKey;
                String value = (String) entryValue;
                this.parameters.put(key, value);
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.properties.clear();
        }
    }

    private void checkParameters() {
        if (Objects.isNull(parameters)) {
            parameters = Maps.newHashMap();
        }
    }

}