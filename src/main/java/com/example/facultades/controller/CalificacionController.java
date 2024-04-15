package com.example.facultades.controller;

import com.example.facultades.service.model.Calificacion;
import com.example.facultades.service.ICalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    private ICalificacionService calificacionService;

    @GetMapping("traer/todas")
    public ResponseEntity<List<Calificacion>> getCalificaciones(){
        List<Calificacion> listaCalificaciones = calificacionService.getCalificaciones();
        return new ResponseEntity<>(listaCalificaciones, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Calificacion> findCalificacion(@PathVariable Long id){
        Optional<Calificacion> calificacion = calificacionService.findCalificacion(id);
        if(calificacion.isPresent())
            return  new ResponseEntity<>(calificacion.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<Calificacion> saveCalificacion(@RequestBody Calificacion calificacion){
       calificacionService.saveCalificacion(calificacion);
        System.out.println(calificacion.getId());
        return new ResponseEntity<>(calificacion, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> deleteCalificacion(@RequestParam Long id){
      String mensaje = calificacionService.deleteCalificacion(id);
      return  new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<Calificacion> editCalificacion(@RequestBody Calificacion calificacion){
        Calificacion calificacion1 = calificacionService.editCalificacion(calificacion);
        return  new ResponseEntity<>(calificacion1, HttpStatus.OK);
    }
}
