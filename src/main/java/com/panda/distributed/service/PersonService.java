package com.panda.distributed.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panda.distributed.domain.Person;

/**
 * 使用feign调用Person Service
 * @author WQXia
 * @date 2017-04-11 15:05:28
 * @version 1.0
 */

@FeignClient("person")
public interface PersonService {

	@RequestMapping(value="/save", method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE, 
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody List<Person> save(@RequestBody String personName);
}
