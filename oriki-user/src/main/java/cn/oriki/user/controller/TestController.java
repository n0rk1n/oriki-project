package cn.oriki.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试用 Controller
 *
 * @author oriki.wang
 */
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/test")
    public String test() {
        // 获取 服务端注册的微服务
        List<String> serviceNames = this.discoveryClient.getServices();
        return serviceNames.toString();
    }

    @Value("${demo-key}")
    private String demoKey;

    @GetMapping("/demo-key")
    public String test1() {
        return this.demoKey;
    }

}
