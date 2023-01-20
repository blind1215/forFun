package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    //내가 어느부분에 적용시킬것인가?
    //포인트컷(어디에적용시킬건인지설정)
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}

    //메소드 실행전
    @Before("cut()")
    public void before(JoinPoint joinPoint){
        //메소드 찍기
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        //컨트롤러 실행시 타입 밸류 찍기
        Object[] args = joinPoint.getArgs();
        for(Object obj : args){
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    //메소드 리턴시
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
