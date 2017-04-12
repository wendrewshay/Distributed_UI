package com.panda.distributed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.panda.distributed.domain.Person;

/**
 * 调用Person Service的断路器
 * @author WQXia
 * @date 2017-04-11 15:13:13
 * @version 1.0
 */

@Service
public class PersonHystrixService {

	@Autowired
	PersonService personService;
	
	//用该注解指定当本方法调用失败时，调用后背方法fallbackSave。
	@HystrixCommand(fallbackMethod="fallbackSave")
	public List<Person> save(String name) {
		return personService.save(name);
	}
	
	public List<Person> fallbackSave() {
		List<Person> list = new ArrayList<>();
		Person person = new Person("Person Service 故障");
		list.add(person);
		return list;
	}
}
