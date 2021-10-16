package com.mefunny.aspect;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 * this logging aspoect is modularization of a cross cutting concern, that cross cutting being logging.
 * we will handle all of the application's logging from here
 * 
 * @Aspect comes from an AspectJ since that is our implementation
 */

@Aspect
@Component
public class LoggingAspect {
/*
 * if this is a logging aspect, I should create a logger
 */	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	/*
	 * now determine where I want my advice to potentially be injected.  I can do this using a Pointcut, which
	 * allows us to use "point cut expressions" to determine where code might later be injected.
	 */
	@Pointcut("within(com.mefunny.service..*)")
	public void serviceLog() {}
	
	
	/*
	 * Lets determine:
	 * 1. what advice should be injected (code that will be injected at some point)
	 * 2. determine when it should be injected(before? after?)
	 */
	/*
	 * this method will use serviceLog() pointcut and the @Before will inject advice before method invokes
	 */
	@Before(value="serviceLog()")
	public void logBeforeService(JoinPoint jp) {
		/*
		 * this is my advice
		 */
		LOGGER.warn("Before Advice. The: "+jp.getSignature().getName() + " Service method has been called.");
	}
	
	@After(value = "serviceLog()")
	public void logAfterService(JoinPoint jp) {
		LOGGER.warn("After Advice. The: "+jp.getSignature().getName() + " Service method has been called.");
	}
	
	/*
	 * injected after a method returns
	 */
	@AfterReturning(value = "serviceLog()", returning = "returnedUsers")
	public void logAfterServiceReturn(JoinPoint jp, Object returnedUsers) {
		LOGGER.warn("Return Advice. The: "+jp.getSignature().getName() + " Service method has returned.");
	}
	
	@AfterThrowing(value = "serviceLog()", throwing = "thrownException")
	public void logAfterServiceException(JoinPoint jp, Exception thrownException) {
		LOGGER.warn("AfterThrowing Advice. The: "+jp.getSignature().getName() 
				+ " method has thrown an exception of type "+ thrownException);
	}
	
	
	
	
	
	@Pointcut("within(com.mefunny.repository..*)")
	public void repositoryLog() {}
	
	
	@Before(value="repositoryLog()")
	public void logBeforeRepository(JoinPoint jp) {
		LOGGER.warn("Before Advice. The: "+jp.getSignature().getName() + " Repository method has been called.");
	}
	
	@AfterReturning(value = "repositoryLog()", returning = "returnedUsers")
	public void logAfterRepositoryReturn(JoinPoint jp, Object returnedUsers) {
		LOGGER.warn("Return Advice. The: "+jp.getSignature().getName() + " Repository method has returned.");
	}
	
	@AfterThrowing(value = "repositoryLog()", throwing = "thrownException")
	public void logAfterRepositoryException(JoinPoint jp, Exception thrownException) {
		LOGGER.warn("AfterThrowing Advice. The: "+jp.getSignature().getName() 
				+ " method has thrown an exception of type "+ thrownException);
	}
	
	@After(value = "repositoryLog()")
	public void logAfterRepository(JoinPoint jp) {
		LOGGER.warn("After Advice. The: "+jp.getSignature().getName() + " Repository method has been called.");
	}
	
	
	
	
//	@Pointcut("within(com.mefunny..*)")
//	public void mefunnyLog() {}
//	
//	
//	@Before(value="mefunnyLog()")
//	public void logBeforeMefunny(JoinPoint jp) {
//		LOGGER.warn("Before Advice. The: "+jp.getSignature().getName() + " method has been called.");
//	}
//	
//	@AfterReturning(value = "mefunnyLog()", returning = "returnedUsers")
//	public void logAfterMefunnyReturn(JoinPoint jp, Object returnedUsers) {
//		LOGGER.warn("Return Advice. The: "+jp.getSignature().getName() + " method has returned.");
//	}
//	
//	@AfterThrowing(value = "mefunnyLog()", throwing = "thrownException")
//	public void logAfterMefunnyException(JoinPoint jp, Exception thrownException) {
//		LOGGER.warn("AfterThrowing Advice. The: "+jp.getSignature().getName() 
//				+ " method has thrown an exception of type "+ thrownException);
//	}
//	
//	@After(value = "mefunnyLog()")
//	public void logAfterMefunny(JoinPoint jp) {
//		LOGGER.warn("After Advice. The: "+jp.getSignature().getName() + " method has been called.");
//	}
//	
	
	
	
	
	@Pointcut("within(com.mefunny.controller..*)")
	public void controllerLog() {}
	
	
	@Before(value="controllerLog()")
	public void logBeforeController(JoinPoint jp) {
		LOGGER.warn("Before Advice. The: "+jp.getSignature().getName() + " Controller method has been called.");
	}
	
	@AfterReturning(value = "controllerLog()", returning = "returnedUsers")
	public void logAfterEncoderController(JoinPoint jp, Object returnedUsers) {
		LOGGER.warn("Return Advice. The: "+jp.getSignature().getName() + " Controller method has returned.");
	}
	
	@AfterThrowing(value = "controllerLog()", throwing = "thrownException")
	public void logAfterEncoderController(JoinPoint jp, Exception thrownException) {
		LOGGER.warn("AfterThrowing Advice. The: "+jp.getSignature().getName() 
				+ " method has thrown an exception of type "+ thrownException);
	}
	
	@After(value = "controllerLog()")
	public void logAfterController(JoinPoint jp) {
		LOGGER.warn("After Advice. The: "+jp.getSignature().getName() + " Controller method has been called.");
	}
	
	
	
	
	
	
	
	@Pointcut("within(com.mefunny.encoder..*)")
	public void encoderLog() {}
	
	
	@Before(value="encoderLog()")
	public void logBeforeEncoder(JoinPoint jp) {
		LOGGER.warn("Before Advice. The: "+jp.getSignature().getName() + " Encoder method has been called.");
	}
	
	@AfterReturning(value = "encoderLog()", returning = "returnedUsers")
	public void logAfterEncoderReturn(JoinPoint jp, Object returnedUsers) {
		LOGGER.warn("Return Advice. The: "+jp.getSignature().getName() + " Encoder method has returned.");
	}
	
	@AfterThrowing(value = "encoderLog()", throwing = "thrownException")
	public void logAfterEncoderException(JoinPoint jp, Exception thrownException) {
		LOGGER.warn("AfterThrowing Advice. The: "+jp.getSignature().getName() 
				+ " method has thrown an exception of type "+ thrownException);
	}
	
	@After(value = "encoderLog()")
	public void logAfterEncoder(JoinPoint jp) {
		LOGGER.warn("After Advice. The: "+jp.getSignature().getName() + " Encoder method has been called.");
	}
	
	

}
