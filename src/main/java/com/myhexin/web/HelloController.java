package com.myhexin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhexin.service.IHelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private IHelloService	iHelloService;
	
	@RequestMapping("/test.do")
	@ResponseBody
	public void hello(){
		System.out.println(iHelloService.hello());
	}
}
