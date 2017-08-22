package com.myhexin.service.impl;

import org.springframework.stereotype.Service;

import com.myhexin.service.IHelloService;

@Service
public class HelloServiceImpl implements IHelloService {

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "Hello";
	}

}
