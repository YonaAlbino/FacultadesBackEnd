package com.example.facultades.repository;

import com.example.facultades.service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario WHERE email = :email AND contrasena = :contrase ", nativeQuery = true)
    Optional<Usuario> findUsuario(String email, String contrase);

    @Query(value = "SELECT email FROM usuario WHERE email = :email ", nativeQuery = true)
    String findByEmail(String email);

}
