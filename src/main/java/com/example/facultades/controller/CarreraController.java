package com.example.facultades.controller;

import com.example.facultades.service.model.Carrera;
import com.example.facultades.service.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private ICarreraService carreraService;

    @GetMapping("/traer/todos")
    public ResponseEntity<List<Carrera>> getCarrera(){
        List<Carrera> listaCarreras = carreraService.getCarrera();
        return new ResponseEntity<>(listaCarreras, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Carrera> findCarrera(@PathVariable Long id){
        Optional<Carrera> Carrera = carreraService.findCarrera(id);
        if(Carrera.isPresent())
            return new ResponseEntity<>(Carrera.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<Carrera> saveCarrera(@RequestBody Carrera carrera){
        Carrera carrera1 = carreraService.saveCarrera(carrera);
        return new ResponseEntity<>(carrera1, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<Carrera> editCarrera(@RequestBody Carrera carrera){
        Carrera carrera1 = carreraService.editCarrera(carrera);
        return new ResponseEntity<>(carrera1, HttpStatus.OK);
    }

   // @DeleteMapping("/eliminarAsociacionCarreraUniversidad")
   // public ResponseEntity<String> eliminarAsociacionCarreraUniversidad(@RequestParam Long id){
    //   String mensaje = carreraService.eliminarAsociacionUiversidadCarrera(id);
    //    return new ResponseEntity<>(mensaje, HttpStatus.OK);
   // }

    @DeleteMapping("/eliminar")
    public  ResponseEntity<String> deleteCarrera(@RequestParam Long id){
        String mensaje = carreraService.deleteCarrera(id);
        return  new ResponseEntity<>(mensaje, HttpStatus.OK);
    }


}
