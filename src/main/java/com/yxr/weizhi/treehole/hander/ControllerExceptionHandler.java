package com.yxr.weizhi.treehole.hander;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liqiqi_tql
 * @date 2020/7/24 -0:48
 */

//错误拦截器


    @ControllerAdvice
    public class ControllerExceptionHandler {

        //    将异常记录到日志
        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        /**
         * @Description: 处理错误信息
         * @Auther: ONESTAR
         * @Date: 21:52 2020/5/20
         * @Param: request：访问的异常URL
         * @Param: e：异常参数
         * @Return: 返回错误信息页面
         */
        @ExceptionHandler(Exception.class)
        public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {

//        记录异常信息：请求的URL，异常信息
            logger.error("Requst URL : {}，Exception : {}", request.getRequestURL(),e);

//        当标识了状态码的时候就不拦截
            if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
                throw e;
            }

//        将记录的异常信息返回到error页面
            ModelAndView mv = new ModelAndView();
            mv.addObject("url",request.getRequestURL());
            mv.addObject("exception", e);
            mv.setViewName("error/error");
            return mv;
        }
    }
