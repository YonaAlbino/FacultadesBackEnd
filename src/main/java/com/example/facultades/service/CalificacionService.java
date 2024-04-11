package com.example.facultades.service;

import com.example.facultades.model.Calificacion;
import com.example.facultades.repository.ICalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CalificacionService implements ICalificacionService{

    @Autowired
    private ICalificacionRepository calificacionRepository;

    @Override
    public List<Calificacion> getCalificaciones() {
        List<Calificacion> listaCalificaciones = calificacionRepository.findAll();
        return listaCalificaciones;
    }

    @Override
    public Calificacion saveCalificacion(Calificacion calificacion) {
        calificacionRepository.save(calificacion);
        return calificacion;
    }

    @Override
    public String deleteCalificacion(Long id) {
        calificacionRepository.deleteById(id);
        return "Calificación elimanada con exito";
    }

    @Override
    public Optional<Calificacion> findCalificacion(Long id) {
        Optional<Calificacion> calificationOptional = calificacionRepository.findById(id);
        return  calificationOptional;
    }

    @Override
    public Calificacion editCalificacion(Calificacion calificacion) {
        this.saveCalificacion(calificacion);
        return calificacion;
    }
}
