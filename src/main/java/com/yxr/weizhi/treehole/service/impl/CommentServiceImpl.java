package com.yxr.weizhi.treehole.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxr.weizhi.treehole.entity.Comment;
import com.yxr.weizhi.treehole.mapper.CommentMapper;
import com.yxr.weizhi.treehole.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-07-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentDao commentDao;

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();


    @Override
    public List<Comment> listComment() {
        //查询出父节点
        List<Comment> comments = commentDao.findByParentIdNull(Long.parseLong("-1"));
        for(Comment comment : comments){
            Long id = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = commentDao.findByParentIdNotNull(id);
            //查询出子评论
            combineChildren(childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }


    private void combineChildren(List<Comment> childComments, String parentNickname1) {
        //判断是否有一级子回复
        if(childComments.size() > 0){
            //循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentNickname);
            }
        }
    }


    private void recursively(Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findByReplayId(childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                //循环迭代找出子集回复
                recursively(replayId,parentNickname);




            }
        }
    }

    @Override
    //存储评论信息
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentDao.saveComment(comment);
    }
}
