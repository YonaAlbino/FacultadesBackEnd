package com.example.facultades.service;

import com.example.facultades.service.model.Reaccion;

import java.util.List;

public interface IReaccionService {
    public List<Reaccion> getMegustas();

    public Reaccion saveMegusta(Reaccion meGusta);
}
