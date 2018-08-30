package cn.oriki.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 用户 Controller
 *
 * @author oriki.wang
 */
@RestController
public class UserController {

    private static final String HTTP_KEY_WORD = "http://";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/login-test")
    public String loginTest(String username, String password) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("oriki-user");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = HTTP_KEY_WORD + host + ":" + port + "oriki-user/login?username=" + username + "&password=" + password + "";
        return this.restTemplate.getForObject(url, String.class);
    }

}
