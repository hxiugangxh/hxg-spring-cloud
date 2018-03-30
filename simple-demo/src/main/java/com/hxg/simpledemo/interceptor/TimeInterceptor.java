package com.hxg.simpledemo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            handler) throws Exception {
//        System.out.println("preHandle");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String className = handlerMethod.getBean().getClass().getName();
        String methodName = handlerMethod.getMethod().getName();

//        System.out.println("请求类: " + className + ",请求方法: " + methodName);

        long startTime = System.currentTimeMillis();
//        System.out.println("传递starTime = " + startTime);
        httpServletRequest.setAttribute("startTime", startTime);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle");

        long startTime = (long) httpServletRequest.getAttribute("startTime");

//        System.out.println("接收到startTime = " + startTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
