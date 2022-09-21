package co.edu.javeriana.libreria.dao;

import co.edu.javeriana.libreria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}