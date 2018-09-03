package cn.oriki.user.entity;

import lombok.*;

import java.util.Date;

/**
 * 用户信息实体类
 *
 * @author oriki.wang
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    private String name;
    private Date birthday;

}
