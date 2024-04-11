package com.example.facultades.service;

import com.example.facultades.model.Respuesta;

import java.util.List;
import java.util.Optional;

public interface IRespuestaService {

    public List<Respuesta> getRespuestas();

    public Respuesta saveRespuestas(Respuesta respuesta);

    public String deleteRespuesta(Long id);

    public Optional<Respuesta> findRespuesta(Long id);

    public Respuesta editRespuesta(Respuesta respuesta);
}
