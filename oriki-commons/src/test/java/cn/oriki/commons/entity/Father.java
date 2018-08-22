package cn.oriki.commons.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Father extends GrandFather {

    private Double salary;

}
