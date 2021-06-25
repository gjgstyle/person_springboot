package com.pratice.eurekaclient.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	Logger log = LoggerFactory.getLogger(AspLog.class);

	/**
	 * 切点
	 */
	@Pointcut("@annotation(com.pratice.eurekaclient.aop.AspLog)")
	public void pointcut() {

	}

	/**
	 * 在切点之前，织入相关代码
	 */
	@Before("pointcut()")
	public void beforeInit(JoinPoint joinPoint) {

		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		AspLog aspLog = signature.getMethod().getAnnotation(AspLog.class);
		log.info("START:"+ aspLog.className() + "." + aspLog.methodName());
	}

	/**
	 * 在切点之后，织入相关代码
	 */
	@After("pointcut()")
	public void afterInit(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		AspLog aspLog = signature.getMethod().getAnnotation(AspLog.class);
		log.info("END:"+ aspLog.className() + "." + aspLog.methodName());
	}

	/**
	 * 环绕，可以在切入点前后织入代码，并且可以自由的控制何时执行切点
	 * @throws Throwable
	 */
	@Around("pointcut()")
	public Object around(JoinPoint joinPoint) throws Throwable {
		ProceedingJoinPoint point = (ProceedingJoinPoint)joinPoint;

		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		AspLog aspLog = signature.getMethod().getAnnotation(AspLog.class);
		log.info("AROUND:"+ aspLog.className() + "." +  aspLog.methodName());

		return point.proceed();
	}

	/**
	 * 在切点返回内容后，织入相关代码，一般用于对返回值做些加工处理的场景
	 */
	/*@AfterReturning("pointcut()")
	public void afterReturning(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		AspLog aspLog = signature.getMethod().getAnnotation(AspLog.class);
		log.info("AfterReturning:"+ aspLog.className() + "." + aspLog.methodName());
	}*/

	/**
	 * 用来处理当织入的代码抛出异常后的逻辑处理
	 */
	/*@AfterThrowing
	public void afterThrowing(){
		log.warn("AfterReturning:切点code异常");
	}*/
}
