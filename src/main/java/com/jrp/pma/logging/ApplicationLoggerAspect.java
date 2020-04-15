package com.jrp.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	//+ "|| within(com.jrp.pma.dao..*)"
	@Pointcut("within(com.jrp.pma.controllers..*)")
	public void definePackagePointcuts() {
		//empty method to specify pointcut location 
	}
	
	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint jp) {
		log.debug("\n \n \n ");
		log.debug("************** Before Method Execution****************  \n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
		log.debug("______________________________________________________ \n \n");
		
		Object o = null;
		
	 try {
		o = jp.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		log.debug("\n \n ");
		log.debug("************** After Method Execution****************  \n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
		log.debug("______________________________________________________ \n \n");
		
		return o ;
	}
}
