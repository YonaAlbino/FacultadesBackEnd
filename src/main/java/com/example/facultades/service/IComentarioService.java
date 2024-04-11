package com.example.facultades.service;

import com.example.facultades.model.Comentario;

import java.util.List;
import java.util.Optional;

public interface IComentarioService {
    public List<Comentario> getComentarios();

    public Comentario saveComentario(Comentario comentario);

    public String deleteComentario(Long id);

    public Optional<Comentario> findComentario(Long id);

    public Comentario editComentario(Comentario comentario);
}
