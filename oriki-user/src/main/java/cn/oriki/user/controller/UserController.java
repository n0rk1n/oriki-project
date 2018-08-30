package cn.oriki.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 Controller
 *
 * @author oriki.wang
 */
@RestController
public class UserController {

    @GetMapping("/login")
    public String login(String username, String password) {
        return "当前登录用户 user : " + username + "--" + password;
    }

}
