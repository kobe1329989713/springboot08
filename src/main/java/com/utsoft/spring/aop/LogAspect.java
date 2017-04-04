package com.utsoft.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <br />日期：2017/4/4
 * <br />时间：22:15
 * <br />创建人：刘坤
 * <br />描述：
 */
@Aspect
@Component
public class LogAspect {

    /**
     * com.utsoft.spring.dao..*.*(..)) 在执行这个包及其子包下所有类的所有方法之前，
     * 先执行这个方法的。然后在回去执行哪个类里面的方法。前置通知。
     */
    @Before("execution(* com.utsoft.spring.dao..*.*(..))")
    public void log() {
        System.out.println("前置通知：  方法之前：");
        System.out.println("获取代理对象：" + AopContext.currentProxy().getClass().getName());
    }


    /**
     * 拿到执行哪个方法的参数
     */
    @After("execution(* com.utsoft.spring.dao..*.*(..))")
    public void logAfter(JoinPoint point) {
        System.out.println("后置通知：  方法之后：");
        System.out.println("拿到执行哪个方法所在的类和参数：" + point.getTarget().getClass().getName()
                + "，参数是：" + Arrays.asList(point.getArgs())
                + "，执行的方法是：" + point.getSignature().getName()
        );
    }

}
