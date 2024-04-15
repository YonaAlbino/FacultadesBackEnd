package com.example.facultades.service;

import com.example.facultades.service.model.Calificacion;

import java.util.List;
import java.util.Optional;

public interface ICalificacionService {

    public List<Calificacion> getCalificaciones();

    public Calificacion saveCalificacion(Calificacion calificacion);

    public String deleteCalificacion(Long id);

    public Optional<Calificacion> findCalificacion(Long id);

    public Calificacion editCalificacion(Calificacion calificacion);
}
