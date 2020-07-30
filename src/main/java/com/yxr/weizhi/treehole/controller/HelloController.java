package com.yxr.weizhi.treehole.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiqi_tql
 * @date 2020/7/29 -15:43
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){

        return "hello!treeHole's user~~I am liqiqiorz,the author of this project!";


    }
}
