package com.example.facultades.controller;

import com.example.facultades.model.Rol;
import com.example.facultades.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/traer/todos")
    public ResponseEntity<List<Rol>> getRoles(){
        List<Rol> listaRoles = rolService.getRoles();
        return new ResponseEntity<>(listaRoles, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Rol> findRol(@PathVariable Long id){
        Optional<Rol> rol = rolService.findRol(id);
        if(rol.isPresent())
            return new ResponseEntity<>(rol.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
        Rol rol1 = rolService.saveRol(rol);
        return new ResponseEntity<>(rol1, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<Rol> editRol(@RequestBody Rol rol){
        Rol rol1 = rolService.editRol(rol);
        return new ResponseEntity<>(rol1, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable Long id){
        String mensaje = rolService.deleteRol(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

}
