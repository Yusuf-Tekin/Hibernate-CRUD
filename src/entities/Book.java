package entities;

import javax.persistence.*;
@Entity
@Table(name = "books")
public class Book implements IBook {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "bookName")
	private String bookName;
	
	@Column(name = "bookAuthor")
	private String bookAuthor;
	
	@Column(name = "pageNumber")
	private int pageNumber;
	
	
	
	public Book(String bookName, String bookAuthor, int pageNumber) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.pageNumber = pageNumber;
	}
	
	public Book() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	

}
