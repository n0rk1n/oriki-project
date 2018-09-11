package cn.oriki.security.controller;

import cn.oriki.commons.response.Responses;
import cn.oriki.security.feign.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

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
        String url = "http://" + serviceName + "/oriki-user/login?username=" + username + "&password=" + password + "";
        return this.restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/login-test2")
    @HystrixCommand(fallbackMethod = "loginTest2Fallback")
    public String loginTest2(String username, String password) {
        // 使用 Feign 的方式进行访问
        return this.userFeignClient.login(username, password);
    }

    private String loginTest2Fallback(String username, String password) {
        LOGGER.error("用户执行 Feign 方式的登录方法失效，登录用户： 用户名： " + username + " ， 密码 ： ****** 。");
        return Responses.responseFail("fail");
    }

}
