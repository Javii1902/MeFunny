package com.mefunny.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.mefunny.service..*)")
	public void serviceLog() {}
	
	
	@Before(value="serviceLog()")
	public void logBeforeService(JoinPoint jp) {
		
		LOGGER.warn("Before Advice. The: "+jp.getSignature().getName() + " method has been called.");
	}
	
	@After(value = "serviceLog()")
	public void logAfterService(JoinPoint jp) {
		LOGGER.warn("After Advice. The: "+jp.getSignature().getName() + " method has been called.");
	}
	
	
	@AfterReturning(value = "serviceLog()", returning = "returnedUsers")
	public void logAfterServiceReturn(JoinPoint jp, Object returnedUsers) {
		LOGGER.warn("Return Advice. The: "+jp.getSignature().getName() + " method has returned.");
	}
	
	@AfterThrowing(value = "serviceLog()", throwing = "thrownException")
	public void logAfterServiceException(JoinPoint jp, Exception thrownException) {
		LOGGER.warn("AfterThrowing Advice. The: "+jp.getSignature().getName() 
				+ " method has thrown an exception of type "+ thrownException);
	}
}
