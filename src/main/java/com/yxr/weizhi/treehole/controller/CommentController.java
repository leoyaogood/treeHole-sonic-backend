package com.yxr.weizhi.treehole.controller;


import com.yxr.weizhi.treehole.entity.Comment;
import com.yxr.weizhi.treehole.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-07-23
 */
@Controller
@RequestMapping("/treehole/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    private String avatar;

    @GetMapping("/")
    public String comment() {
        return "comment";
    }

    @GetMapping("/comment")
    public String comments(Model model) {
        List<Comment> comments = commentService.listComment();
        model.addAttribute("comments", comments);
        return "comment :: commentList";
    }

    @PostMapping("/comment")
    public String post(Comment comment) {
        //设置头像
        comment.setAvatar(avatar);
        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);
        return "redirect:/comment";
    }

}

