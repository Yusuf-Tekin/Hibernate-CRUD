import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import business.BookManager;
import entities.Book;

public class Main {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml") // HQL için gerekli konfigürasyon dosyasýný verme
				.addAnnotatedClass(Book.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		BookManager bookManager = new BookManager(session);
		
		try{
			session.beginTransaction();
			
			Book book1 = new Book("Benim Kitabým", "Yusuf Tekin", 250);
			//bookManager.addBook(book1); // Kitap veritabanýna eklendi
			
			List<Book> books = bookManager.getAllBooks(); // Veritabanýndaki tüm kitaplar
			
//			for(Book book:books) {
//				System.out.println(book.getBookName() + "-" + book.getBookAuthor());
//			}
			
			Book book = bookManager.getBookById(3); // 3 numaralý id'ye sahip kitap
//			System.out.println(book.getBookName());
			
			
			List<Book> bookAuthor = bookManager.getBookByAuthor("Mustafa Kemal Atatürk"); // Yazara ait kitaplar listesi
			
			// bookManager.updateBookName(3, "Güncellenmiþ Kitap Adý"); Kitap adý güncelleme
			
			bookManager.deleteBook(book); //id'si 3 olarak bulunan kitabý veritabanýndan silme 
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
		
		
	}

}
