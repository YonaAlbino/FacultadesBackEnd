package com.example.facultades.service;

import com.example.facultades.service.model.Rol;
import com.example.facultades.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RolService implements  IRolService{

    @Autowired
    private IRolRepository rolRepository;
    @Override
    public List<Rol> getRoles() {
        List<Rol> listaRoles = rolRepository.findAll();
        return listaRoles;
    }

    @Override
    public Rol saveRol(Rol rol) {
        Rol rolGuardado = rolRepository.save(rol);
        return rolGuardado;
    }

    @Override
    public String deleteRol(Long id) {
        rolRepository.deleteById(id);
        return "Rol eliminado con exito";
    }

    @Override
    public Optional<Rol> findRol(Long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        return rolOptional;
    }

    @Override
    public Rol editRol(Rol rol) {
        Rol rolGuardado = this.saveRol(rol);
        return rol;
    }
}
