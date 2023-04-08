package com.haohao.handler;

import com.haohao.parser.MyUserParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class UserHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user",new MyUserParser());
	}
}
