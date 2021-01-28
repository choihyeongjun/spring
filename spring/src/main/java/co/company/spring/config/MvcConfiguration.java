package co.company.spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import co.company.spring.common.AuthCheckInterceptor;


@Configuration
@EnableWebMvc//annotation-driven
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MvcConfiguration implements WebMvcConfigurer{
	/**
	 * 언어 변경을 위한 인터셉터를 생성한다.
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	    interceptor.setParamName("lang");
	    return interceptor;
	}

	/**
	 * 변경된 언어 정보를 기억할 로케일 리졸퍼를 생성한다.
	 * 여기서는 세션에 저장하는 방식을 사용한다.
	 * @return
	 */
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}

	/**
	 * 인터셉터를 등록한다.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(localeChangeInterceptor());
	    registry.addInterceptor(authCheckInterceptor()).addPathPatterns("/emp*");
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms=new ResourceBundleMessageSource();
		ms.setBasenames("message.label");
		ms.setDefaultEncoding("utf-8");
		return ms;
	}
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	@Bean CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multi=new CommonsMultipartResolver();
		multi.setMaxUploadSize(1024*10000);
		return multi;
	}
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(3);
		return resolver;
	}

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		//이거없으면 이미지 넣을때 에러뜸 조심
	}
	@Bean
	BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver bean=new BeanNameViewResolver();
		bean.setOrder(1);
		return bean;
	}
	
	
}
