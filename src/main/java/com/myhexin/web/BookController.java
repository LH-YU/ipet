package com.myhexin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhexin.entity.Book;
import com.myhexin.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IBookService iBookService;

	/**
	 * 购买一本书
	 * 
	 * @return
	 */
	@RequestMapping(value = "/order.do")
	@ResponseBody
	public Object orderOneBook(HttpServletRequest request) {
		Book b = new Book();
		b.setBasePrice(120.50);
		b.setClz("computer");
		b.setName("C plus programing");
		b.setSalesArea("China");
		b.setYears(2);

		double realPrice = iBookService.getBookSalePrice(b);
		request.setAttribute("book", b);
		System.out.println(b.getName() + ":" + realPrice);

		return b;
	}
}
