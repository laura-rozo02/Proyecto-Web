package co.edu.javeriana.libreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioDetailsService implements UserDetailsService  {
  @Autowired
  UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<co.edu.javeriana.libreria.domain.User> listOfUsers = userService.listAll(); //se toma la lista de los users
    Map<String, String> usuarios = new HashMap<>();
    Map<String, String> contrasenas = new HashMap<>();

    for (co.edu.javeriana.libreria.domain.User user : listOfUsers) {
      usuarios.put(user.getUsername(), user.getPermit()); //se llena mapa de usuarios con el username y el rol y se asocian
      contrasenas.put(user.getUsername(), user.getPassword()); ///se llena mapa de contraseñas con el username y la contra y se asocian
      //se usa un mapa para que no se repitan y validar que no hay un user con el username
    }

    var rol = usuarios.get(username);
    //verificar que exista en el map ese user

    if (rol != null) {
      //userbuilder ya de spring para añadir-->constructor
      User.UserBuilder userBuilder = User.withUsername(username); //se le asigna el username a un usuario
      PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      String encryptedPassword = passwordEncoder.encode(contrasenas.get(username)); // se saca la contraseña y la encripta por eso hay otro map con las contraseñas

      userBuilder.password(encryptedPassword).roles(rol); //al userbuilder se le mete la contraseña encriptada y el rol

      return userBuilder.build();
    } else {
      throw new UsernameNotFoundException(username);
    }
  }
}