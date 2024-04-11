package com.example.facultades.repository;

import com.example.facultades.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICarreraRepository extends JpaRepository<Carrera, Long> {

    //@Modifying
   // @Query("DELETE FROM UniversidadListaCarreras u WHERE u.listaCarrerasId = :id")
    //void eliminarAsociacionUniversidadCarrera(@Param("id") Long id);

}
