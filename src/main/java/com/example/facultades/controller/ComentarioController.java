package com.example.facultades.controller;

import com.example.facultades.model.Comentario;
import com.example.facultades.service.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private IComentarioService comentarioService;

    @GetMapping("/traer/todos")
    public ResponseEntity<List<Comentario>> getComentarios(@RequestBody Comentario comentario){
        List<Comentario> listaComentarios = comentarioService.getComentarios();
        return new ResponseEntity<>(listaComentarios, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Comentario> findComentario(@PathVariable long id){
        Optional<Comentario> comentario = comentarioService.findComentario(id);
        if(comentario.isPresent())
            return new ResponseEntity<>(comentario.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<Comentario> saveComentario(@RequestBody Comentario comentario){
        Comentario comentario1 = comentarioService.saveComentario(comentario);
        System.out.println("id de comentario " + comentario1.getId());
        return new ResponseEntity<>(comentario1, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<Comentario> editComentario(@RequestBody Comentario comentario){
        Comentario comentario1 = comentarioService.editComentario(comentario);
        return new ResponseEntity<>(comentario1, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteComentario(@PathVariable Long id){
       String mensaje = comentarioService.deleteComentario(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
