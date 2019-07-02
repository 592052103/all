package com.soecode.lyf.entity;

public class Book {
	
	private long bookId;// 图书ID

    private String name;// 图书名称
    
	private int number;// 馆藏数量

    public long getBookId() {
		return bookId;
	}

    //对象的实例属性定义为私有的，但是获取其属性的方法是共有的Public
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
