package com.xiang.core;

import com.xiang.core.elasticsearch.EnableSearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableSearch
public class CoreApplication {

	public static void main(String[] args) {
		// devtools：是spring boot的一个热部署工具
		// 设置 spring.devtools.restart.enabled 属性为false，可以关闭该特性.
		// System.setProperty("spring.devtools.restart.enabled","false");

		SpringApplication.run(CoreApplication.class, args);
	}
}
