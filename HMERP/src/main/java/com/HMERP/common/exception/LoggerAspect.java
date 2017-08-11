package com.HMERP.common.exception;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.slf4j.Slf4j;



@Slf4j
//@Component
//@Aspect
public class LoggerAspect {
    
    //@Around("execution(* com.seoul.his..service.*Impl.*(..)) or execution(* com.seoul.his..controller.*Controller.*(..)) or execution(* com.seoul.his..applicationService.*Impl.*(..))")
    public Object aroundLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        String type = joinPoint.getSignature().getDeclaringTypeName();
        
        log.debug("{}.{}() Ω√¿€", type, name);
        
        Object returnValue = joinPoint.proceed();
        
        log.debug("{}.{}() ≥°", type, name);
        
        return returnValue;
        
    }
}
