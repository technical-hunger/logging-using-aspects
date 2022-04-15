package com.technicalhunger.logging.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	
	@Around("@annotation(loggable)")
	public Object loggingAspect(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
		
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		
		logger.info(joinPoint.getSignature().getName() +": Start");
		try {
		
			Object returnObject = joinPoint.proceed();
			logger.info(joinPoint.getSignature().getName() +": Complete");
			return returnObject;
		}catch(Throwable throwable) {
			
			logger.error(joinPoint.getSignature().getName() +": Exception:",throwable);
			throw throwable;
		}
	}
}
