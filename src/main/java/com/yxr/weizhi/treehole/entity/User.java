package com.yxr.weizhi.treehole.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author liqiqi_tql
 * @date 2020/7/24 -0:44
 */
@Data
public class User {

    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;
}
