package com.soecode.lyf;

import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.dao.BookDao;
import com.soecode.lyf.service.impl.BookServiceImpl;

public class TEST {

	 @Autowired
	 private BookDao bookDao;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookServiceImpl bookImpl = new BookServiceImpl();
		bookImpl.getById(1);


	}

}
