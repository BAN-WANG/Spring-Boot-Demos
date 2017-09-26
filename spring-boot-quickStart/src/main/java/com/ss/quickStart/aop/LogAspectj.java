package com.ss.quickStart.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wsy
 * \* Date: 2017/9/26
 * \* Time: 15:15
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Aspect
@Component
public class LogAspectj {
    private static final Logger LOG = LoggerFactory.getLogger(LogAspectj.class);

    @Before(value = "@annotation(com.ss.quickStart.annotation.Log)")
    public void logAfterReturning(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        LOG.info("方法:{}.{},参数:{}",className,methodName,JSON.toJSONString(args));
    }
}