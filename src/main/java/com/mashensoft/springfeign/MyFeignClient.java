package com.mashensoft.springfeign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient(name = "SERVICE-PROVIDE")
public interface MyFeignClient {
	@RequestMapping("/")
	public Map<String,Object> getMap();
}
