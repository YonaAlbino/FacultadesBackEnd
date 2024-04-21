package com.example.facultades.repository;

import com.example.facultades.service.model.Carrera;
import com.example.facultades.service.model.CarreraDto;
import com.example.facultades.service.model.Universidad;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICarreraRepository extends JpaRepository<Carrera, Long> {

    //@Modifying
   // @Query("DELETE FROM UniversidadListaCarreras u WHERE u.listaCarrerasId = :id")
    //void eliminarAsociacionUniversidadCarrera(@Param("id") Long id);

    @Query("SELECT carrera, AVG(c.nota) AS promedio " +
            "FROM Carrera carrera " +
            "JOIN carrera.listaCalificacion c " +
            "GROUP BY carrera " +
            "ORDER BY promedio DESC")
    List<Carrera> getTopCarreras(Pageable pageable);








}
