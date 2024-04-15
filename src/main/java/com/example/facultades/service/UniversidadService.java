package com.example.facultades.service;

import com.example.facultades.excepciones.RegistroExistenteException;
import com.example.facultades.service.model.Universidad;
import com.example.facultades.repository.IUniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UniversidadService implements IUniversidadService {


    @Autowired
    private IUniversidadRepository universidadRepository;
    @Override
    public List<Universidad> getUniversidades() {
        List<Universidad> listaUniversidades = universidadRepository.findAll();
        return  listaUniversidades;
    }

    @Override
    public Universidad saveUniversidad(Universidad universidad) throws RegistroExistenteException {
        Universidad universidadGuardada = null;
        if(!this.universidadExistente(universidad.getNombre()))
            universidadGuardada =  universidadRepository.save(universidad);
        return  universidadGuardada;
    }
    
    public boolean universidadExistente(String nombreUniversidad) throws RegistroExistenteException {
        String nombre = universidadRepository.buscarUniversidadPorNombre(nombreUniversidad);
        System.out.println(nombre);
        if(nombre == null)
            return false;
        throw new RegistroExistenteException("La universidad que desas ingresar ya existe");
    }

    @Override
    public String deleteUniversidad(Long id) {
        universidadRepository.deleteById(id);
        return "Universidad eliminada  exitasamente";
    }

    @Override
    public Optional<Universidad> findUniversidad(Long id) {
       Optional<Universidad> universidadOptional = universidadRepository.findById(id);
       return universidadOptional;
    }

    @Override
    public Universidad editUniversidad(Universidad universidad) throws RegistroExistenteException {
       Universidad universidadGuardada = universidadRepository.save(universidad);
        return universidadGuardada;

    }

    @Override
    public List<Universidad> obtenerTresPrimerasImagenes() {
        Pageable pageable = PageRequest.of(0, 3); // Limitar a las tres primeras universidades
        List<Universidad> universidades = universidadRepository.findTop3UniversidadesByPromedioNota(pageable);
        return universidades;
    }

    @Override
    public Page<Universidad> obtenerUniversidadesPaginadas(Pageable pageable) {
        return universidadRepository.findAll(pageable);
    }
}
