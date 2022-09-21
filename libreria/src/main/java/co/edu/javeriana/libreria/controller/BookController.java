package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.domain.Book;
import co.edu.javeriana.libreria.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/public/books") //listar los libros
    public List<Book> list() {
        return bookService.listAll();
    }

    @GetMapping("/public/book/{id}") //obtener libro por id
    public ResponseEntity<Book> get(@PathVariable Integer id) {
        try {
            Book book = bookService.get(id);

            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/admin/books") //crear libro 
    public void add(@RequestBody Book book) {
        bookService.save(book);
    }

    @PutMapping("/admin/book/{id}")  //actualizar un libro
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable Integer id) {
        try {
            Book existingBook = bookService.get(id);
            System.out.println(existingBook);
            bookService.save(book);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/book/{id}") //borrar libro
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }
}