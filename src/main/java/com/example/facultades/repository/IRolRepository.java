package com.example.facultades.repository;

import com.example.facultades.service.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<Rol, Long> {
}
