package com.panda.distributed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 使用ribbon调用Some Service，并使用断路器
 * @author WQXia
 * @date 2017-04-11 15:21:08
 * @version 1.0
 */
@Service
public class SomeHystrixService {

	//springboot 下使用Ribbon，我们只需要注入一个RestTemplate即可，springboot已为我们做好了配置
	@Autowired
	RestTemplate restTemplate;
	
	//本方法调用失败时调用后备方法fallbackSome
	@HystrixCommand(fallbackMethod="fallbackSome")
	public String getSome() {
		return restTemplate.getForObject("http://some/getsome", String.class);
	}
	
	public String fallbackSome() {
		return "Some Service 故障";
	}
}
