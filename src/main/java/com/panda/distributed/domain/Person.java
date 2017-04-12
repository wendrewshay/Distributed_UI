package com.panda.distributed.domain;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7982873151510163922L;
	private Integer id;
	private String name;
	private String age;
	private String address;
	
	public Person(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
