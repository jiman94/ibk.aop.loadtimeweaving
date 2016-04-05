package common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@Aspect
public class StopWatchAspect {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	StopWatch stopWatch = new StopWatch();
	static String name = "";
	static String type = "";


	// 사전충고(Before Advice)
	@Before("execution (* com.ibk.ltw..*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		stopWatch.start();

		String toLongString = joinPoint.getSignature().toLongString();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		Package pkgName = joinPoint.getTarget().getClass().getPackage();
		String type = joinPoint.getSignature().getDeclaringTypeName();

/*		if (type.indexOf("Controller") > -1) {
			name = "Controller  \t:  ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl  \t:  ";
		} else if (type.indexOf("DAO") > -1) {
			name = "DAO  \t\t:  ";
		}*/

		
		try {
			logger.debug("logBefore::--------------------");
			logger.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
			logger.error("<<<<toLongString=" + toLongString);
			logger.error("<<<<methodName=" + methodName);
			logger.error("<<<<className=" + className);
			logger.error("<<<<pkgName=" + pkgName);

		} finally {
			stopWatch.stop();
			logger.error(stopWatch.prettyPrint());
		}

	}

	// 사후중고(After Advice), 타겟메소드 실행 후 즉시 실행
	@After("execution (* org.springframework.samples..*Service.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		stopWatch.start();

		String toLongString = joinPoint.getSignature().toLongString();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		Package pkgName = joinPoint.getTarget().getClass().getPackage();
		String type = joinPoint.getSignature().getDeclaringTypeName();

		if (type.indexOf("Controller") > -1) {
			name = "Controller  \t:  ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl  \t:  ";
		} else if (type.indexOf("DAO") > -1) {
			name = "DAO  \t\t:  ";
		}

		
		try {
			logger.debug("logAfter::--------------------");
			logger.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
			logger.error("<<<<toLongString=" + toLongString);
			logger.error("<<<<methodName=" + methodName);
			logger.error("<<<<className=" + className);
			logger.error("<<<<pkgName=" + pkgName);

		} finally {
			stopWatch.stop();
			logger.error(stopWatch.prettyPrint());
		}
	}

	// 사후중고(After Returnning Advice), 타겟메소드 리턴 후 실행
	@AfterReturning(pointcut = "execution (* org.springframework.samples..util.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		stopWatch.start();

		String toLongString = joinPoint.getSignature().toLongString();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		Package pkgName = joinPoint.getTarget().getClass().getPackage();
		String type = joinPoint.getSignature().getDeclaringTypeName();

		if (type.indexOf("Controller") > -1) {
			name = "Controller  \t:  ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl  \t:  ";
		} else if (type.indexOf("DAO") > -1) {
			name = "DAO  \t\t:  ";
		}

		
		try {
			logger.debug("logAfterReturning::--------------------");
			logger.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
			logger.error("<<<<toLongString=" + toLongString);
			logger.error("<<<<methodName=" + methodName);
			logger.error("<<<<className=" + className);
			logger.error("<<<<pkgName=" + pkgName);

		} finally {
			stopWatch.stop();
			logger.error(stopWatch.prettyPrint());
		}
	}

	// 주변충고(Around Advice), 타겟메소드 실행전, 리턴 후 두번 충고 실행
	@Around("execution (* org.springframework.samples..*Repository.*(..))")
	public String logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		stopWatch.start();

		String toLongString = joinPoint.getSignature().toLongString();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		Package pkgName = joinPoint.getTarget().getClass().getPackage();
		String type = joinPoint.getSignature().getDeclaringTypeName();

		if (type.indexOf("Controller") > -1) {
			name = "Controller  \t:  ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl  \t:  ";
		} else if (type.indexOf("DAO") > -1) {
			name = "DAO  \t\t:  ";
		}
		try {
			logger.debug("logAround::--------------------");
			logger.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
			logger.error("<<<<toLongString=" + toLongString);
			logger.error("<<<<methodName=" + methodName);
			logger.error("<<<<className=" + className);
			logger.error("<<<<pkgName=" + pkgName);

		} finally {
			stopWatch.stop();
			logger.error(stopWatch.prettyPrint());
		}

		joinPoint.getSignature().getName();
		Arrays.toString(joinPoint.getArgs());
		joinPoint.proceed();

		return "이 문장으로 원래 타겟메소드 리턴이 대체됨!";
	}

	// 예외충고(Throws Advice), 예외가 발생했을 때 예외전에 충고실행
	@AfterThrowing(pointcut = "execution (* org.springframework.samples..*Impl.*(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		stopWatch.start();

		String toLongString = joinPoint.getSignature().toLongString();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		Package pkgName = joinPoint.getTarget().getClass().getPackage();
		String type = joinPoint.getSignature().getDeclaringTypeName();

		if (type.indexOf("Controller") > -1) {
			name = "Controller  \t:  ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl  \t:  ";
		} else if (type.indexOf("DAO") > -1) {
			name = "DAO  \t\t:  ";
		}
		try {
			logger.debug("logAfterThrowing::--------------------");
			logger.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
			logger.error("<<<<toLongString=" + toLongString);
			logger.error("<<<<methodName=" + methodName);
			logger.error("<<<<className=" + className);
			logger.error("<<<<pkgName=" + pkgName);

		} finally {
			stopWatch.stop();
			logger.error(stopWatch.prettyPrint());
		}

		
		joinPoint.getSignature().getName();
	}

}