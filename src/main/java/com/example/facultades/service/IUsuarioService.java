package com.example.facultades.service;

import com.example.facultades.excepciones.ContrasenaNoEncontradaException;
import com.example.facultades.excepciones.EmailNoEncontradoException;
import com.example.facultades.service.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<Usuario> getUsuarios();

    public Usuario saveUsuario(Usuario usuario);

    public String deleteUsuario(Long id);

    public Optional<Usuario> findUsuario(Long id);

    public Usuario editUsuario(Usuario usuario);

    public Usuario loguin(String email, String contrasena) throws EmailNoEncontradoException, ContrasenaNoEncontradaException;
}
