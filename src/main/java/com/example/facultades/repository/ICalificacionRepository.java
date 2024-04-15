package com.example.facultades.repository;

import com.example.facultades.service.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICalificacionRepository extends JpaRepository<Calificacion, Long> {


}
