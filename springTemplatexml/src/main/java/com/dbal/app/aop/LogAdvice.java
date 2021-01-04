package com.dbal.app.aop;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	public void printLog(JoinPoint jp) {
		String method=jp.getSignature().getName();
		Object[] param=jp.getArgs();
		System.out.println("[공통 로그] before"+method
				+"\n"+
				((param!=null)?param[0]:""));
	}
}
