package com.itwill1.bean.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("singleton")
@Lazy
//@Lazy(value=true)
@DependsOn({})
@Component(value = "annotationBean")
public class AnnotationBean {
	public AnnotationBean() {
		System.out.println("### AnnotationBean()생성자");
	}
	@PostConstruct
	public void myInit() {
		System.out.println("### AnnotationBean.myInit()메쏘드호출");
	}
	@PreDestroy
	public void myDestroy() {
		System.out.println("### AnnotationBean.myDestroy()메쏘드호출");
	}
	
}
