package com.dbal.app.aop;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	public void afterLog(JoinPoint jp,Object returnObj) {
		String method=jp.getSignature().getName();
		System.out.println("[공통 로그] after"
				+method+"\n"+returnObj);
	}
}
