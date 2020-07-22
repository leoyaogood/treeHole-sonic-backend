package com.yxr.weizhi.treehole.mapper;

import com.yxr.weizhi.treehole.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-07-23
 */
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    //添加一个评论
    int saveComment(Comment comment);

    //查询父级评论
    List<Comment> findByParentIdNull(@Param("ParentId") Long ParentId);

    //查询一级回复
    List<Comment> findByParentIdNotNull(@Param("id") Long id);

    //查询二级以及所有子集回复
    List<Comment> findByReplayId(@Param("childId") Long childId);
}
