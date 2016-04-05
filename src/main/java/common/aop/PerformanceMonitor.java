package common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class PerformanceMonitor
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitor.class);

	
	@Pointcut("execution(* com.ibk.ltw..*.*(..))")
	public void inAllMethod(){
	}

	@Before("inAllMethod()")
	public void logBefor(JoinPoint joinPoint_p)
	{
		StringBuffer sb = new StringBuffer();

		sb.append("\n");
		sb.append("*======================================");	
		sb.append("\n");
		sb.append("*       PERFORMANCE STATISTICS        *");
		sb.append("\n");
		sb.append("*======================================");
		sb.append("\n");
		sb.append("*  Method Name: " + joinPoint_p.getSignature().toLongString());
		sb.append("\n");
		sb.append("\n");
		sb.append("*======================================");

		LOGGER.debug(sb.toString());
	}
	
	
	@After("inAllMethod()")
	public void log(JoinPoint joinPoint_p)
	{
		StringBuffer sb = new StringBuffer();

		sb.append("\n");
		sb.append("*======================================");
		sb.append("\n");
		sb.append("*       PERFORMANCE STATISTICS        *");
		sb.append("\n");
		sb.append("*======================================");
		sb.append("\n");
		sb.append("*  Method Name: " + joinPoint_p.getSignature().toLongString());
		sb.append("\n");
		sb.append("\n");
		sb.append("*======================================");

		LOGGER.debug(sb.toString());
	}
}