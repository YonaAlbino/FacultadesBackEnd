package com.example.facultades.controller;

import com.example.facultades.service.ReaccionService;
import com.example.facultades.service.model.Reaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reaccion")
public class ReaccionController {

    @Autowired
    private ReaccionService reaccionService;

    @GetMapping("/traerTodas")
    public ResponseEntity<List<Reaccion>> getMeGustas(){
        List<Reaccion> listaReaccion = reaccionService.getMegustas();
        return  new ResponseEntity<>(listaReaccion, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Reaccion> saveMegusta(@RequestBody Reaccion reaccion){
        Reaccion reaccion1 = reaccionService.saveMegusta(reaccion);
        return new ResponseEntity<>(reaccion1, HttpStatus.OK);
    }
}
