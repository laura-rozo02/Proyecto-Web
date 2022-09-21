package co.edu.javeriana.libreria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import co.edu.javeriana.libreria.service.UsuarioDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UsuarioDetailsService usuarioDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() { //Se crea un password encoder
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .headers().frameOptions().disable().and() //opciones para que deje ver en la base de datos
        .httpBasic(withDefaults()) //para la autenticacion basica 
        .authorizeRequests()
        .antMatchers("/console/**").permitAll() //todas las url que temgan esto un user normal lo puede hacer
        .antMatchers("/public/**").permitAll()//todas las url que temgan esto un user normal lo puede hacer
        .antMatchers("/admin/**").hasRole("ADMIN")//todas las url que temgan admin un admin lo puede hacer
        .anyRequest().authenticated(); //para saber que debe estar autenticado de manera correcta
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception { //utiliza los detalles de la clase UsuarioDetails
    auth.userDetailsService(usuarioDetailsService); //para verificar el rol
  }
}