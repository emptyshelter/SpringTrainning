package com.itwill1.bean.annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextMain {

	public static void main(String[] args) {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill1/bean/annotation/1.bean_annotation.xml");
		System.out.println("-------------Spring Container초기화끝----------");
		AnnotationBean annotationBean1 = (AnnotationBean) applicationContext.getBean("annotationBean");
		AnnotationBean annotationBean2 = (AnnotationBean) applicationContext.getBean("annotationBean");
		AnnotationBean annotationBean3 = (AnnotationBean) applicationContext.getBean("annotationBean");
		System.out.println("annotation1"+annotationBean1);
		System.out.println("annotation2"+annotationBean2);
		System.out.println("annotation3"+annotationBean3);
	}

}
