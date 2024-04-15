package com.example.facultades.service;

import com.example.facultades.service.model.Respuesta;
import com.example.facultades.repository.IRespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RespuestaService implements IRespuestaService{

    @Autowired
    private IRespuestaRepository respuestaRepository;

    @Override
    public List<Respuesta> getRespuestas() {
        List<Respuesta> listaRespuesta = respuestaRepository.findAll();
        return listaRespuesta;
    }

    @Override
    public Respuesta saveRespuestas(Respuesta respuesta) {
       Respuesta respuestaGuardada = respuestaRepository.save(respuesta);
        return respuestaGuardada;
    }

    @Override
    public String deleteRespuesta(Long id) {
        respuestaRepository.deleteById(id);
        return "Respuesta eliminada con exito";
    }

    @Override
    public Optional<Respuesta> findRespuesta(Long id) {
        Optional<Respuesta> optionalRespuesta = respuestaRepository.findById(id);
        return  optionalRespuesta;
    }

    @Override
    public Respuesta editRespuesta(Respuesta respuesta) {
        Respuesta respuestaGuardada = this.saveRespuestas(respuesta);
        return respuestaGuardada;
    }
}
