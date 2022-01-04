package business;

import java.util.List;

import entities.Book;

public interface IBookService {
	
	
	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public List<Book> getBookByAuthor(String authorName);
	public List<Book> largeNumberOfPage(int pageNumber); // Sayfa sayýsý parametreden büyük olan kitaplar
	
	public void addBook(Book book);
	
	
	public void updateBookName(int id,String name);
	public void updateBookAuthor(int id,String author);
	public void updateBookPageNumber(int id,int pageNumber);
	
	public void deleteBook(Book book);

}
