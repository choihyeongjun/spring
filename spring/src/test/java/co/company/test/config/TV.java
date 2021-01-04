package co.company.test.config;

import org.springframework.stereotype.Component;

/*@Component//controller,service,repository
*/public class TV {
	public TV() {
		System.out.println("TV 생성됨");
	}
	public void init() {
		System.out.println("init 실행됨");
	}
	public void destroy() {
		System.out.println("destroy 소멸됨");
	}
}
