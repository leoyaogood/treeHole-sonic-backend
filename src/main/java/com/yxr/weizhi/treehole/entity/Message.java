package com.yxr.weizhi.treehole.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liqiqi_tql
 * @date 2020/7/24 -22:50
 */
public class Message {



    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentMessageId;
    private boolean adminMessage;

    //回复留言
    private List<Message> replyMessages = new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;

}
