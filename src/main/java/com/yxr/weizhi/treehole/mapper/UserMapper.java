package com.yxr.weizhi.treehole.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxr.weizhi.treehole.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author liqiqi_tql
 * @date 2020/7/24 -1:09
 */
public interface UserMapper extends BaseMapper<User> {
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
