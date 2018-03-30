package com.hxg.simpledemo.aspect;

import com.hxg.simpledemo.aspect.vo.DurationVo;
import com.hxg.simpledemo.aspect.vo.HttpLogVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用AOP将执行方法以及耗时记录进日志
 * 一个方法中可设置多个切面
 */

@Aspect
@Configuration
@Slf4j
public class AspectLog {

    public void myLog(String msg) {
        log.info(msg);
    }

    /**
     * 申明切面
     */
    @Pointcut("execution(*  com..controller..*.*(..))")
    public void controllerPointcut() {
    }

    @Pointcut("execution(*  com..service..*.*(..))")
    public void servicePointcut() {
    }

    @Pointcut("execution(*  com..repository..*.*(..))")
    public void repositoryPointcut() {
    }

    /**
     * 合并多个切面
     */
    @Pointcut("controllerPointcut()||servicePointcut()||repositoryPointcut()")
    public void methodPointcut() {
    }

    /*打印每个方法的耗时*/
    @Around("methodPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        myLog("请求耗时记录：" + new DurationVo(joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName(), end - start).toString());

        return result;
    }


    /*拦截http request*/
    @Before("controllerPointcut()")
    public void httpBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        HttpLogVo httpLogVo = new HttpLogVo();
        httpLogVo.setUrl(request.getRequestURL().toString());
        httpLogVo.setHttpMethod(request.getMethod());
        httpLogVo.setClientIp(request.getRemoteAddr());
        httpLogVo.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
        httpLogVo.setArgs(joinPoint.getArgs());

        myLog("http请求记录" + httpLogVo.toString());
    }


    /*拦截http response*/
    @AfterReturning(returning = "object", pointcut = "controllerPointcut()")
    public void doAfterReturning(Object object) {
       /* if (!(object instanceof RestResult)) {
            throw new RestException("返回结果类型错误");
        }*/

        myLog("http返回记录:" + object);
    }

}