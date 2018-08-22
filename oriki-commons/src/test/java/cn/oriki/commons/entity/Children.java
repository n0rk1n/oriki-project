package cn.oriki.commons.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class Children extends Father {

    private String name;
    private Integer age;

}
