package com.example.facultades.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String grado;
    private String duracion;

    private boolean activa =  true;

    @OneToMany()
    private List<Comentario> listaComentarios;

    @OneToMany()
    private List<Calificacion> listaCalificacion;
}
