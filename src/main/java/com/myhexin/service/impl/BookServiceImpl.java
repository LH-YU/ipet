package com.myhexin.service.impl;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.myhexin.entity.Book;
import com.myhexin.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@KSession("bookprice_ksession")
	private KieSession kSession;

	/**
	 * 获取一本书的当前实际售价
	 * 
	 * @param b
	 * @return
	 */
	public double getBookSalePrice(Book b) {
		if (b == null) {
			throw new NullPointerException("Book can not be null.");
		}

		kSession.insert(b);
		System.out.println("fact对象输入");
		kSession.fireAllRules();

		return b.getSalesPrice();
	}

}
