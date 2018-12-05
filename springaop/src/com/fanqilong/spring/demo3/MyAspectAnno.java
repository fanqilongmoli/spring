package com.fanqilong.spring.demo3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类：注解的切面类
 */
@Aspect
public class MyAspectAnno {

    /**
     * 前置通知
     */
    @Before(value = "MyAspectAnno.pointcut2()")
    public void before() {
        System.out.println("前置增强==============");
    }

    /**
     * 后置通知
     *
     * @param result
     */
    @AfterReturning(value = "execution(* com.fanqilong.spring.demo3.OrderDao.delete(..))", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("后置增强==============" + result);
    }

    /**
     * 环绕通知
     */
    @Around(value = "execution(* com.fanqilong.spring.demo3.OrderDao.update(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前===============");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后===============");
        return proceed;
    }

    /**
     * 异常抛出通知
     */
    @AfterThrowing(value = "MyAspectAnno.pointcut1()", throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println("异常抛出通知===============");
        System.out.println(e.getMessage());
    }

    /**
     * 最终通知
     */
    @After(value = "MyAspectAnno.pointcut1()")
    public void after(){
        System.out.println("最终通知===============");
    }

    //切入点注解： 切入点配置
    @Pointcut(value ="execution(* com.fanqilong.spring.demo3.OrderDao.find(..))" )
    private void pointcut1(){

    }

    //切入点注解： 切入点配置
    @Pointcut(value ="execution(* com.fanqilong.spring.demo3.OrderDao.save(..))" )
    private void pointcut2(){

    }


}
