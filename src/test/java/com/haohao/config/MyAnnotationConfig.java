package com.haohao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.haohao")
@PropertySource("classpath:product.properties")
public class MyAnnotationConfig {

}
