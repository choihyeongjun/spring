package co.company.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages= {"co.company.test"})
public class IOCConfiguration {
	/*
	 * @Bean(initMethod="init",destroyMethod="destroy")
	 * 
	 * @Scope("prototype") public TV tv() { return new TV(); }
	 */
	
}
