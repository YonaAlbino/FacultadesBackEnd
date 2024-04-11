package com.example.facultades.service;

import com.example.facultades.model.Carrera;

import java.util.List;
import java.util.Optional;

public interface ICarreraService {
    public List<Carrera> getCarrera();

    public Carrera saveCarrera(Carrera carrera);

    public String deleteCarrera(Long id);

    public Optional<Carrera> findCarrera(Long id);

    public Carrera editCarrera(Carrera carrera);

   // public String eliminarAsociacionUiversidadCarrera(Long id);
}
