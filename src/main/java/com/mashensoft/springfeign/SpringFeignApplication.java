package com.mashensoft.springfeign;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RestController
public class SpringFeignApplication {
	@Autowired
	MyFeignClient myFeignClient;
	private static final Logger log = LoggerFactory.getLogger(SpringFeignApplication.class);
	@RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
	public Map<String,Object> hello() {
		log.info("我是微服务feign，调用另外几个微服务");
		Map mapResult = myFeignClient.getMap();
		log.info("服务端返回："+mapResult);
		return mapResult;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFeignApplication.class, args);
	}

}
