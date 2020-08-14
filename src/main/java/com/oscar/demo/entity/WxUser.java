package com.oscar.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class WxUser extends BaseEntity implements Serializable {
    private Integer id;
    private String wxid;
    private String nickname;
    private String mobile;
}
