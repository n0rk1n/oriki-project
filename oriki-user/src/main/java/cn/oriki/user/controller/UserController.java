package cn.oriki.user.controller;

import cn.oriki.commons.util.Jsons;
import cn.oriki.commons.util.Md5s;
import cn.oriki.user.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * 用户 Controller
 *
 * @author oriki.wang
 */
@RestController()
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password)
            throws NoSuchAlgorithmException {
        LOGGER.info("登录用户--username ： " + username + " , password ： ****** ;");

        UserInfo userInfo = new UserInfo();
        {
            userInfo.setId(0L);
            userInfo.setUsername(username);
            userInfo.setPassword(Md5s.getMd5(password));
            userInfo.setPhoneNumber("18888888888");
            userInfo.setName("normalUser");
            userInfo.setBirthday(new Date());
        }
        return Jsons.toJson(userInfo);
    }

}
