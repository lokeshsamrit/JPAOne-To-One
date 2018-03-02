package com.hellokoding.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hellokoding.jpa.model.Book;
import com.hellokoding.jpa.model.BookDetail;
import com.hellokoding.jpa.model.Patient;
import com.hellokoding.jpa.model.User;
import com.hellokoding.jpa.repository.BookRepository;
import com.hellokoding.jpa.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
@SpringBootApplication
public class JpaOneToOneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneApplication.class, args);
	}
	private static final Logger logger = LoggerFactory.getLogger(JpaOneToOneApplication.class);

	@Autowired
    private BookRepository bookRepository;

	@Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of books
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book A", new BookDetail(49)));
        books.add(new Book("Book B", new BookDetail(59)));
        books.add(new Book("Book C", new BookDetail(69)));
        bookRepository.save(books);
        
        Patient p = new Patient();
        p.setName("lokesh");
        User u = new User();
        p.setUserDetail(u);
        
        patientRepository.save(p);

        // fetch all books
        for (Book book : bookRepository.findAll()) {
            logger.info(book.toString());
        }
    }
}
