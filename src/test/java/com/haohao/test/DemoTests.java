package com.haohao.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.junit.Test;

public class DemoTests {
	@Test
	public void test1(){
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		Object bean = beanFactory.getBean("user");
		System.err.println(bean);
	}
	//下面这个代码和test1作用是相同的
	@Test
	public void test2(){
		//XmlBeanFactory是DefaultListableBeanFactory的子类，添加了Xml读取的功能
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//利用Resource加载配置文件
		ClassPathResource resource = new ClassPathResource("applicationContext.xml");
		//添加Reader到工厂
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		//把配置文件添加到工厂中
		xmlBeanDefinitionReader.loadBeanDefinitions(resource);
		Object bean = beanFactory.getBean("user");
		System.err.println(bean);
	}
	@Test
	public void test3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object u = applicationContext.getBean("u");
		System.err.println(u);
	}

}
