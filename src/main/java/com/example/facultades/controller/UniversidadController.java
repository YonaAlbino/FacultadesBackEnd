package com.example.facultades.controller;

import com.example.facultades.excepciones.RegistroExistenteException;
import com.example.facultades.service.model.Universidad;
import com.example.facultades.service.IUniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        if (universidad.isPresent()) {
            return new ResponseEntity<>(universidad.get(), HttpStatus.OK);
        }
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

    @GetMapping("/obtenerTopUniversidades")
    public ResponseEntity<List<Universidad>> obtenerPrimerasTresImagenes(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue =  "10") int tamanio)
    {
        List<Universidad> universidades = universidadService.obtenerTopUniversidades(pagina, tamanio);
        return new ResponseEntity<>(universidades, HttpStatus.OK);
    }

    @GetMapping("/paginadas")
    public ResponseEntity<List<Universidad>>  obtenerUniversidadesPaginadas(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue =  "10") int tamanio)
    {
        Pageable pageable = PageRequest.of(pagina, tamanio);
        Page<Universidad> universidades = universidadService.obtenerUniversidadesPaginadas(pageable);
        List<Universidad> listaUniversidades = universidades.getContent();
        return new ResponseEntity<>(listaUniversidades, HttpStatus.OK);
    }

    @GetMapping("/universidadID/{idCarrera}")
    public ResponseEntity<Universidad>  getuniversidadIdCarrera(@PathVariable Long idCarrera){
           Universidad universidad = universidadService.getIDUniversidadPorCarreraId(idCarrera);
        return new ResponseEntity<>(universidad, HttpStatus.OK);
    }

    @GetMapping("/findUniversidadByName/{nombreUniversidad}")
    public ResponseEntity<List<Universidad>> findUniversidadByName(@PathVariable String nombreUniversidad) {
        List<Universidad> ListaUniversidades = universidadService.getUniversidadByName(nombreUniversidad);
        return new ResponseEntity<>(ListaUniversidades, HttpStatus.OK);
    }

}
