package com.example.facultades.service;

import com.example.facultades.service.model.Comentario;
import com.example.facultades.repository.IComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComentarioService implements IComentarioService{

    @Autowired
    private IComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> getComentarios() {
        List<Comentario> listaComentario = comentarioRepository.findAll();
        return listaComentario;
    }

    @Override
    public Comentario saveComentario(Comentario comentario) {
      Comentario comentarioGuardado =  comentarioRepository.save(comentario);
        return comentarioGuardado;
    }

    @Override
    public String deleteComentario(Long id) {
        comentarioRepository.deleteById(id);
        return "Comentario eliminado con exito";
    }

    @Override
    public Optional<Comentario> findComentario(Long id) {
        Optional<Comentario> comentarioOptional = comentarioRepository.findById(id);
        return comentarioOptional;
    }

    @Override
    public Comentario editComentario(Comentario comentario) {
        Comentario comentarioGuardado =  this.saveComentario(comentario);
        return comentarioGuardado;
    }

    @Override
    public List<Comentario> findComentariosByUniversidadId(Long idUniversidad, int cantidadRegistros, int pagina) {
        Pageable pageable = PageRequest.of(cantidadRegistros, pagina);
        List<Comentario> listaComentarios = comentarioRepository.findComentariosByUniversidadId(idUniversidad, pageable);
        return listaComentarios;
    }

    @Override
    public List<Comentario> findComentariosByCarreraId(Long idCarrera, int cantidadRegistros, int pagina) {
        Pageable pageable = PageRequest.of(cantidadRegistros, pagina);
        List<Comentario> listaComentarios = comentarioRepository.findComentariosByCarreraId(idCarrera, pageable);
        return listaComentarios;
    }
}
