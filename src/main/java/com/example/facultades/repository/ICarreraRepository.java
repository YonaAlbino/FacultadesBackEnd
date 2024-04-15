package com.example.facultades.repository;

import com.example.facultades.service.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarreraRepository extends JpaRepository<Carrera, Long> {

    //@Modifying
   // @Query("DELETE FROM UniversidadListaCarreras u WHERE u.listaCarrerasId = :id")
    //void eliminarAsociacionUniversidadCarrera(@Param("id") Long id);

}
