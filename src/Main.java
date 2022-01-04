import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import business.BookManager;
import entities.Book;

public class Main {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml") // HQL i�in gerekli konfig�rasyon dosyas�n� verme
				.addAnnotatedClass(Book.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		BookManager bookManager = new BookManager(session);
		
		try{
			session.beginTransaction();
			
			Book book1 = new Book("Benim Kitab�m", "Yusuf Tekin", 250);
			//bookManager.addBook(book1); // Kitap veritaban�na eklendi
			
			List<Book> books = bookManager.getAllBooks(); // Veritaban�ndaki t�m kitaplar
			
//			for(Book book:books) {
//				System.out.println(book.getBookName() + "-" + book.getBookAuthor());
//			}
			
			Book book = bookManager.getBookById(3); // 3 numaral� id'ye sahip kitap
//			System.out.println(book.getBookName());
			
			
			List<Book> bookAuthor = bookManager.getBookByAuthor("Mustafa Kemal Atat�rk"); // Yazara ait kitaplar listesi
			
			// bookManager.updateBookName(3, "G�ncellenmi� Kitap Ad�"); Kitap ad� g�ncelleme
			
			bookManager.deleteBook(book); //id'si 3 olarak bulunan kitab� veritaban�ndan silme 
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
		
		
	}

}
