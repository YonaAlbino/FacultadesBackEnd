package com.example.facultades.service;

import com.example.facultades.excepciones.RegistroExistenteException;
import com.example.facultades.service.model.Universidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUniversidadService {
    public List<Universidad> getUniversidades();

    public Universidad saveUniversidad(Universidad universidad) throws  RegistroExistenteException;

    public String deleteUniversidad(Long id);

    public Optional<Universidad> findUniversidad(Long id);

    public Universidad editUniversidad(Universidad universidad) throws RegistroExistenteException;

    public List<Universidad>obtenerTopUniversidades(int cantidadRegistros, int pagina);


    Page<Universidad> obtenerUniversidadesPaginadas(Pageable pageable);
}
