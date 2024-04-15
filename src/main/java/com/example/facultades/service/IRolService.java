package com.example.facultades.service;

import com.example.facultades.service.model.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {

    public List<Rol> getRoles();

    public Rol saveRol(Rol rol);

    public String deleteRol(Long id);

    public Optional<Rol> findRol(Long id);

    public Rol editRol(Rol rol);
}
