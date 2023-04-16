package com.haohao.test;

import com.haohao.config.MyAnnotationConfig;
import com.haohao.service.UserServiceImpl;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.junit.Test;

public class DemoTests {
	@Test
	public void test1(){
		//读取xml配置文件，并且把bean封装成BF，之后再在spring的容器中注册
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//创建bean对象，并且得到这个bean对象，需要注意的是bean的创建是懒惰的，调用的时候才会创建
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
	//测试注解自动注入bean和set注入
	@Test
	public void test4(){
		//到这里调用了构造方法，读取了配置文件
		//这个工厂是一个加强版的beanFactory
		//进里面看看
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyAnnotationConfig.class);
		Object product = ctx.getBean("product");
		System.err.println("product = " + product);

	}
	@Test
	public void test5(){
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl userService = (UserServiceImpl) c.getBean("userService");
		userService.register();
	}



}
