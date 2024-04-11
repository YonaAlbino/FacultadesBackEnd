package com.example.facultades.controller;

import com.example.facultades.excepciones.RegistroExistenteException;
import com.example.facultades.excepciones.UniversidadRepetidaException;
import com.example.facultades.model.Universidad;
import com.example.facultades.service.IUniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {

    @Autowired
    private IUniversidadService universidadService;

    @GetMapping("traer/todas")
    public ResponseEntity<List<Universidad>> getUniversidades(){
        List<Universidad> listaUniversidades = universidadService.getUniversidades();
        return new ResponseEntity<>(listaUniversidades, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Universidad> findUniversidad(@PathVariable Long id){
        Optional<Universidad> universidad = universidadService.findUniversidad(id);
        if (universidad.isPresent())
            return new ResponseEntity<>(universidad.get(), HttpStatus.OK);
        return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<Universidad> saveUniversidad(@RequestBody Universidad universidad) throws RegistroExistenteException {
        universidadService.saveUniversidad(universidad);
        return new ResponseEntity<>(universidad, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<Universidad> editUniversidad(@RequestBody Universidad universidad) throws  RegistroExistenteException {
        System.out.println(universidad +  "universdiadddd");
        universidadService.editUniversidad(universidad);
        return new ResponseEntity<>(universidad, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarUniversidad(@RequestParam Long id){
        String mensaje = universidadService.deleteUniversidad(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/primerasTresImagenes")
    public ResponseEntity<List<Universidad>> obtenerPrimerasTresImagenes(){
        List<Universidad> universidades = universidadService.obtenerTresPrimerasImagenes();
        return new ResponseEntity<>(universidades, HttpStatus.OK);
    }


}
