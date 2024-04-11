package com.example.facultades.service;

import com.example.facultades.excepciones.RegistroExistenteException;
import com.example.facultades.excepciones.UniversidadRepetidaException;
import com.example.facultades.model.Universidad;

import java.util.List;
import java.util.Optional;

public interface IUniversidadService {
    public List<Universidad> getUniversidades();

    public Universidad saveUniversidad(Universidad universidad) throws  RegistroExistenteException;

    public String deleteUniversidad(Long id);

    public Optional<Universidad> findUniversidad(Long id);

    public Universidad editUniversidad(Universidad universidad) throws RegistroExistenteException;

    public List<Universidad> obtenerTresPrimerasImagenes();



}
