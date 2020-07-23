package com.yxr.weizhi.treehole.hander;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author liqiqi_tql
 * @date 2020/7/24 -0:49
 */
//找不到资源跳转404

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class NotFoundException extends RuntimeException{
        public NotFoundException() {
        }

        public NotFoundException(String message) {
            super(message);
        }

        public NotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

