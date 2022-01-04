package business;

import java.util.List;

import org.hibernate.Session;

import entities.Book;

public class BookManager implements IBookService {
	
	Session session;
	public BookManager(Session session) {
		this.session = session;
	}
	
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks = session.createQuery("from Book").getResultList();
		return allBooks;
	}
	@Override
	public Book getBookById(int id) {
		Book book = session.get(Book.class, id);
		return book;
	}
	@Override
	public List<Book> getBookByAuthor(String authorName) {
		List<Book> getBooksByAuthor = session.createQuery(String.format("from Book book where book.bookAuthor = '%s'", authorName)).getResultList();
		return getBooksByAuthor;
	}
	@Override
	public List<Book> largeNumberOfPage(int pageNumber) {
		List<Book> largeNumberBook = session.createQuery(String.format("from Book book where book.pageNumber > %d", pageNumber)).getResultList();
		return largeNumberBook;
	}
	@Override
	public void addBook(Book book) {
		session.save(book);
	}
	@Override
	public void updateBookName(int id, String name) {
		Book book = getBookById(id);
		book.setBookName(name);
		session.save(book);
	}
	@Override
	public void updateBookAuthor(int id, String author) {
		
		Book book = getBookById(id);
		book.setBookAuthor(author);
		session.save(book);
	}
	@Override
	public void updateBookPageNumber(int id, int pageNumber) {
		Book book = getBookById(id);
		book.setPageNumber(pageNumber);
		session.save(book);
		
		
	}
	@Override
	public void deleteBook(Book book) {
		session.delete(book);
	}

}
