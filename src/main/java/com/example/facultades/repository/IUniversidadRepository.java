package com.example.facultades.repository;

import com.example.facultades.service.model.Universidad;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUniversidadRepository extends JpaRepository<Universidad, Long> {
    @Query(value = "Select nombre FROM universidad WHERE nombre = :nombreUniversidad", nativeQuery = true)
    String buscarUniversidadPorNombre(String nombreUniversidad);


    //@Query("SELECT u FROM Universidad u ORDER BY u.id ASC LIMIT 3")
    //List<Universidad> findImagenesPrimerasTres();

    @Query("SELECT u, AVG(c.nota) AS promedio " +
            "FROM Universidad u " +
            "JOIN u.listaCalificacion c " +
            "GROUP BY u " +
            "ORDER BY promedio DESC")
    List<Universidad> getTopUniversidades(Pageable pageable);

    @Query("SELECT u " +
            "FROM Universidad u " +
            "JOIN u.listaCarreras lc " +
            "WHERE lc.id = :listaCarrerasId")
    Universidad getIDUniversidadPorCarreraId(@Param("listaCarrerasId") Long carreraId);

    @Query("SELECT u AS universidad " +
            "FROM Universidad u " +
            "WHERE u.nombre LIKE %:nombreUniversidad%")
    List<Universidad> getUniversidadByName(String nombreUniversidad);





}
