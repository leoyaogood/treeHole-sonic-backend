package com.yxr.weizhi.treehole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liqiqi_tql
 * @date 2020/7/24 -0:47
 */
//首页控制器

    @Controller
    public class IndexController {
        //通过get方式请求路径
        @GetMapping("/")
        public String index(){
            return "index";
        }
    }

