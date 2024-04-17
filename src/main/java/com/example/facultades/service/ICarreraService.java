package com.example.facultades.service;

import com.example.facultades.service.model.Carrera;
import com.example.facultades.service.model.CarreraDto;
import com.example.facultades.service.model.Universidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICarreraService {
    public List<Carrera> getCarrera();

    public Carrera saveCarrera(Carrera carrera);

    public String deleteCarrera(Long id);

    public Optional<Carrera> findCarrera(Long id);

    public Carrera editCarrera(Carrera carrera);

    Page<Carrera> obtenerCarrerasPaginadas(Pageable pageable);

    public List<Carrera> getTopCarreras(int cantidadRegistros, int pagina);



    // public String eliminarAsociacionUiversidadCarrera(Long id);
}
