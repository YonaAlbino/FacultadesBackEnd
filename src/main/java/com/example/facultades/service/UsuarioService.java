package com.example.facultades.service;

import com.example.facultades.excepciones.ContrasenaNoEncontradaException;
import com.example.facultades.excepciones.EmailNoEncontradoException;
import com.example.facultades.excepciones.ExcepcionDePrueba;
import com.example.facultades.model.Usuario;
import com.example.facultades.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        return  listaUsuarios;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
      Usuario usuarioGuardado =  usuarioRepository.save(usuario);
        return  usuarioGuardado;
    }

    @Override
    public String deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario eliminado con exito";
    }

    @Override
    public Optional<Usuario> findUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional;
    }

    @Override
    public Usuario editUsuario(Usuario usuario) {
      Usuario usuarioGuardado =  this.saveUsuario(usuario);
        return usuarioGuardado;
    }


    @Override
    public Usuario loguin(String email, String contrasena) throws EmailNoEncontradoException, ContrasenaNoEncontradaException {

        String emailUsuario =  usuarioRepository.findByEmail(email);

        if(emailUsuario != null) {
            Optional<Usuario> usuario = usuarioRepository.findUsuario(email, contrasena);
            if(!usuario.isPresent())
                throw new ContrasenaNoEncontradaException();
            return usuario.get();
        }
            throw new EmailNoEncontradoException();
        }

    }



