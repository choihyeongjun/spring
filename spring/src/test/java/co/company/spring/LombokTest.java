package co.company.spring;

import co.company.spring.controller.Member;

public class LombokTest {
	public static void main(String[] args) {
				Member member=Member.builder().name("최형준").cont(1).str(11).build();
	}
}
