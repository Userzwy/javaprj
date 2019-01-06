package com.zwy.javabook.entity;

public class Book {
	private int bookid;//书的编号
	private String bookname;//书的名字
	private String bookauthor;//书的作者
	private String bookdate;
	private String booknumber;
	
	public String getBookdate() {
		return bookdate;
	}
	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}
	public String getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
//	public String getBookdate() {
//		return bookdate;
//	}
//	public void setBookdate(String bookdate) {
//		this.bookdate = bookdate;
//	}
//	public String getBooknumber() {
//		return booknumber;
//	}
//	public void setBooknumber(String booknumber) {
//		this.booknumber = booknumber;
//	}
}
	