package cn.oriki.security.controller;

import cn.oriki.security.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final RestTemplate restTemplate;
    private final UserFeignClient userFeignClient;

    @Autowired
    public UserController(RestTemplate restTemplate, UserFeignClient userFeignClient) {
        this.restTemplate = restTemplate;
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/login-test")
    public String loginTest(String username, String password) {
        // 引入 Ribbon ，添加 @LoadBalanced 的情况，使用 RestTemplate 进行访问
        String serviceName = "oriki-user";
        String url = HTTP_KEY_WORD + serviceName + "/oriki-user/login?username=" + username + "&password=" + password + "";
        return this.restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/login-test2")
    public String loginTest2(String username, String password) {
        // 使用 Feign 的方式进行访问
        return this.userFeignClient.login(username, password);
    }

}
