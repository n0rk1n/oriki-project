package cn.oriki.user.controller;

import cn.oriki.commons.response.Responses;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试用 Controller
 *
 * @author oriki.wang
 */
@RestController
public class ConfigTestController {

    /**
     * 从 Configuration 中获取数据
     */
    @Value("${demo-key}")
    private String demoKey;

    @GetMapping("/demo-key")
    public String loadConfiguration() {
        return this.demoKey;
    }

}
