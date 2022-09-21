package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.domain.User;
import co.edu.javeriana.libreria.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users") //listar los usuarios
    public List<User> list() {
        return userService.listAll();
    }

    @GetMapping("/admin/user/{id}") //obtener usuario por id
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/admin/users") //crear un usuario
    public void add(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/admin/user/{id}") //actualizar un usuario
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existingUser = userService.get(id);
            userService.save(user);
            System.out.println(existingUser);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/user/{id}") //borrar el usuario
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PutMapping("/admin/user/{id}/deactivate") //desactivar un usuario
    public ResponseEntity<?> deactivate(@PathVariable Integer id) {
        User user = get(id).getBody();

        if (user.isActivated()) {
            user.setActivated(false);

            return update(user, id);
        } 

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
