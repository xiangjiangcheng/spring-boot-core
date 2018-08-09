package com.xiang.core;

import com.xiang.core.elasticsearch.EnableSearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableSearch
public class CoreApplication extends SpringBootServletInitializer{

	// 继承SpringBootServletInitializer 实现configure 方便打war 外部服务器部署。
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CoreApplication.class);
	}

	public static void main(String[] args) throws Exception {
		// devtools：是spring boot的一个热部署工具
		// 设置 spring.devtools.restart.enabled 属性为false，可以关闭该特性.
		// System.setProperty("spring.devtools.restart.enabled","false");

		SpringApplication.run(CoreApplication.class, args);
	}

	/*public static void main(String[] args) {
		// devtools：是spring boot的一个热部署工具
		// 设置 spring.devtools.restart.enabled 属性为false，可以关闭该特性.
		// System.setProperty("spring.devtools.restart.enabled","false");

		SpringApplication.run(CoreApplication.class, args);
	}*/
}