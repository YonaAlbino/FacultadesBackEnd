package com.example.facultades.repository;

import com.example.facultades.service.model.Reaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMegustaRepository extends JpaRepository<Reaccion, Long> {
}
