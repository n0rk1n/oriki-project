package cn.oriki.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public String test() {
        // 获取 服务端注册的微服务
        List<String> serviceNames = this.discoveryClient.getServices();
        return serviceNames.toString();
    }

}
