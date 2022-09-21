package co.edu.javeriana.libreria.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import co.edu.javeriana.libreria.controller.BookController;
import co.edu.javeriana.libreria.controller.UserController;
import co.edu.javeriana.libreria.domain.*;

@Component
public class DatabaseInit implements ApplicationRunner {
    @Autowired
    BookController bookController;

    @Autowired
    UserController userController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Book book = new Book("testBook");
        bookController.add(book);

        Book book2 = new Book("secondTestBook");
        bookController.add(book2);

        User user = new User("laurarozo02", "hola", "Laura", "Rozo", "12/11/2009", "CEO", "ADMIN", true);
        userController.add(user);

        User user2 = new User("test03", "adios","Test", "User", "25/02/2040", "CEO", "USER", true);
        userController.add(user2);
    }
}
