package co.edu.javeriana.libreria.dao;

import co.edu.javeriana.libreria.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}