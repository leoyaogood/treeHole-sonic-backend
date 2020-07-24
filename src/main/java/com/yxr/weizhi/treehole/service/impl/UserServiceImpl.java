package com.yxr.weizhi.treehole.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxr.weizhi.treehole.entity.User;
import com.yxr.weizhi.treehole.mapper.UserMapper;
import com.yxr.weizhi.treehole.service.UserService;
import com.yxr.weizhi.treehole.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liqiqi_tql
 * @date 2020/7/24 -1:15
 */
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

   
    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
