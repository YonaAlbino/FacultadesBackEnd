package com.example.facultades.repository;

import com.example.facultades.service.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComentarioRepository extends JpaRepository<Comentario, Long> {


}
