package cn.oriki.security.controller;

import cn.oriki.security.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("login-test")
    public String loginTest(String username, String password) {
        // 添加 @LoadBalanced 的情况
        String serviceName = "oriki-user";
        String url = HTTP_KEY_WORD + serviceName + "/oriki-user/login?username=" + username + "&password=" + password + "";
        return this.restTemplate.getForObject(url, String.class);
    }

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/login-test2")
    public String loginTest2(String username, String password) {
        return this.userFeignClient.login(username, password);
    }

}
