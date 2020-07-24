package com.yxr.weizhi.treehole.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxr.weizhi.treehole.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author liqiqi_tql
 * @date 2020/7/24 -1:14
 */

@Service
public interface UserService extends IService<User> {

    //核对用户名和密码
    User checkUser(String username, String password);
}
