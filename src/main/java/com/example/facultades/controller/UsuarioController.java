package com.example.facultades.controller;

import com.example.facultades.excepciones.ContrasenaNoEncontradaException;
import com.example.facultades.excepciones.EmailNoEncontradoException;
import com.example.facultades.service.model.Usuario;
import com.example.facultades.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/traer/todos")
    public ResponseEntity<List<Usuario>> getUsuario()   {
        List<Usuario> listaUsuarios = usuarioService.getUsuarios();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> findUsuario(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.findUsuario(id);
        if(usuario.isPresent())
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        Usuario usuario1 =  usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(usuario1, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.editUsuario(usuario);
        return new ResponseEntity<>(usuario1, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        String mensaje = usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }


    @PostMapping("/loguin")
    public ResponseEntity<Usuario> loguinUsuario(@RequestParam String email, @RequestParam String contrasena) throws EmailNoEncontradoException, ContrasenaNoEncontradaException {
        Usuario usuario = usuarioService.loguin(email, contrasena);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
