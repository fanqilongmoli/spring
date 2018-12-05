package com.fanqilong.spring.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 */
public class MyAspectXml {
    /**
     * 前置通知
     *
     * @param joinPoint
     */
    public void checkPri(JoinPoint joinPoint) {
        System.out.println("权限校验==================" + joinPoint);
    }

    /**
     * 后置通知
     */
    public void writeLog(Object result) {
        System.out.println("日志记录==================" + result);
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前==========");

        Object proceed = joinPoint.proceed();

        System.out.println("环绕后==========");
        return proceed;
    }

    /**
     * 异常通知
     */
    public void afterThrowing(Throwable ex) {
        System.out.println("异常抛出通知===========" + ex.getMessage());
    }

    /**
     * 最终通知 相当于finally代码块
     */
    public void after(){
        System.out.println("最终通知==============");
    }
}
