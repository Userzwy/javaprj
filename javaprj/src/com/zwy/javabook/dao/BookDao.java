package com.zwy.javabook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zwy.javabook.entity.Book;
import com.zwy.javabook.entity.BookBean;

import com.google.gson.Gson;

public class BookDao extends BaseDao{
	/*
	 * 序列化和反序列化 JSON 的 GOOGLE 插件
	 */
	private static Gson gson = new Gson();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DELETE("2"));
		System.out.println(SELECT());
	}
	
	public static String SELECT() throws ClassNotFoundException, SQLException {
		
		Connection con = BaseDao.getConnection();
		String sql = "select * from book";
		PreparedStatement ps = con.prepareStatement(sql);
		List<Book> bookList = new ArrayList<Book>();
		// 获得查询出来的结果集合
		ResultSet rs =ps.executeQuery();
		// 如果结果集合不为空 do while
		while (rs.next()) {
			Book book = new Book();
			// 声明一本书的类，并且往里添加数据，一一对应
			book.setBookid(rs.getInt("bookid"));
			book.setBookname(rs.getString("bookname"));
			book.setBookauthor(rs.getString("bookauthor"));
			book.setBookdate(rs.getString("bookdate"));
			book.setBooknumber(rs.getString("booknumber"));
			// 最后把这本书添加到书的集合列表 booksList
			bookList.add(book);
		}
		
		BookBean bookBean = new BookBean();
		// 图书的列表
		bookBean.setBooks(bookList);
		// 图书的总数
		bookBean.setTotal(String.valueOf(bookList.size()));
		BaseDao.closeAll(con, ps, rs);
		return gson.toJson(bookBean);
	}

	
	public static String DELETE	(String id) throws ClassNotFoundException, SQLException {
		try {
			Connection con = BaseDao.getConnection();
			String sql = "DELETE FROM book WHERE id=?;";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			ps.executeUpdate();
			BaseDao.closeAll(con, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "true";
	}

	
	 
	public static String UPDATE(String json) throws ClassNotFoundException, SQLException {
		// 使用 Gson 将 JSON 转换成 emtity 实体类 Book
		Book book = gson.fromJson(json, Book.class);
		try {
			Connection con = BaseDao.getConnection();
			String sql = "update book set name = ? ,author = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getBookauthor());
			ps.setInt(3, book.getBookid());
			ps.executeUpdate();
			BaseDao.closeAll(con, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "true";
	}
	
	public static String INSERT(String json) throws ClassNotFoundException, SQLException {
		// 使用 Gson 将 JSON 转换成 emtity 实体类 Book
		Book book = gson.fromJson(json, Book.class);
		try {
			Connection con = BaseDao.getConnection();
			String sql = "INSERT INTO book (name,author) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getBookauthor());
			ps.executeUpdate();
			BaseDao.closeAll(con, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "true";
	}
}
