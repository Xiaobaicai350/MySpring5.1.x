package com.haohao.parser;

import com.haohao.Entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;

import org.w3c.dom.Element;

public class MyUserParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute("name");
		String password = element.getAttribute("password");

		builder.addPropertyValue("name",name);
		builder.addPropertyValue("password",password);
	}
}
