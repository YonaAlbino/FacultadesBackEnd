package com.example.facultades.service;

import com.example.facultades.repository.IMegustaRepository;
import com.example.facultades.service.model.Reaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaccionService implements IReaccionService {

    @Autowired
    private IMegustaRepository megustaRepository;

    @Override
    public List<Reaccion> getMegustas() {
        List<Reaccion> listaReaccion = megustaRepository.findAll();
        return listaReaccion;
    }

    @Override
    public Reaccion saveMegusta(Reaccion meGusta) {
        Reaccion reaccion = megustaRepository.save(meGusta);
        return meGusta;
    }
}
