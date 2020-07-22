package com.yxr.weizhi.treehole.service;

import com.yxr.weizhi.treehole.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-07-23
 */
public interface CommentService extends IService<Comment> {


    //查询评论列表
    List<Comment> listComment();

    //保存评论
    int saveComment(Comment comment);
}
