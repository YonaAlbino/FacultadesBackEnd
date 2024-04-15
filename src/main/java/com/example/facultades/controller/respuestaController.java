package com.example.facultades.controller;

import com.example.facultades.service.model.Respuesta;
import com.example.facultades.service.IRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/respuesta")
public class respuestaController {

    @Autowired
    private IRespuestaService respuestaService;

    @GetMapping("/traer/todos")
    public ResponseEntity<List<Respuesta>> getRespuestas(){
        List<Respuesta> listaRespuestas = respuestaService.getRespuestas();
        return new  ResponseEntity<>(listaRespuestas, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Respuesta> findRespuesta(@PathVariable Long id){
        Optional<Respuesta> respuesta = respuestaService.findRespuesta(id);
        if(respuesta.isPresent())
            return new ResponseEntity<>(respuesta.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar")
    public ResponseEntity<Respuesta> editRespuesta(@RequestBody Respuesta respuesta){
        System.out.println(respuesta.getListaRespuesta());
        Respuesta respuesta1 = respuestaService.editRespuesta(respuesta);
        return new ResponseEntity<>(respuesta1, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Respuesta> saveRespuesta(@RequestBody Respuesta respuesta){
        Respuesta respuesta1 = respuestaService.saveRespuestas(respuesta);
        return new ResponseEntity<>(respuesta1, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteRespuesta(@PathVariable Long id){
        String mensaje = respuestaService.deleteRespuesta(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
