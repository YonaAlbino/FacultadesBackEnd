package com.example.facultades.service;

import com.example.facultades.service.model.Carrera;
import com.example.facultades.repository.ICarreraRepository;
import com.example.facultades.service.model.CarreraDto;
import com.example.facultades.service.model.Universidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CarreraService implements ICarreraService{

    @Autowired
    private ICarreraRepository carreraRepository;

    @Override
    public List<Carrera> getCarrera() {
        List<Carrera> listaCarrera = carreraRepository.findAll();
        return  listaCarrera;
    }

    @Override
    public Carrera saveCarrera(Carrera carrera) {
        carreraRepository.save(carrera);
        return carrera;
    }

    @Override
    public String deleteCarrera(Long id) {
        carreraRepository.deleteById(id);
        return "Carrera eliminada con exito";
    }

    @Override
    public Optional<Carrera> findCarrera(Long id) {
        Optional<Carrera> carreraOptional = carreraRepository.findById(id);
        return carreraOptional;
    }

    @Override
    public Carrera editCarrera(Carrera carrera) {
        this.saveCarrera(carrera);
        return carrera;
    }

    @Override
    public Page<Carrera> obtenerCarrerasPaginadas(Pageable pageable) {
        return carreraRepository.findAll(pageable);
    }

    @Override
    public List<Carrera> getTopCarreras(int cantidadRegistros, int pagina) {
        Pageable pageable = PageRequest.of(cantidadRegistros, pagina);
        List<Carrera> carreras = carreraRepository.getTopCarreras(pageable);
        return carreras;
    }



    //@Override
    //public String eliminarAsociacionUiversidadCarrera(Long id) {
      //  carreraRepository.eliminarAsociacionUniversidadCarrera(id);
       // return "La asociación entre la carrera con el id " + id + " se ha eliminado con exito" ;
    //}
}
