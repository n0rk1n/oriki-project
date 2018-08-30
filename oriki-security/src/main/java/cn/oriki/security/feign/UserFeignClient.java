package cn.oriki.security.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * oriki-user 的 FeignClient
 *
 * @author oriki.wang
 */
@FeignClient(value = "oriki-user")
public interface UserFeignClient {

    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 请求结果
     */
    @GetMapping("/oriki-user/login")
    String login(@RequestParam("username") String username, @RequestParam("password") String password);

}
