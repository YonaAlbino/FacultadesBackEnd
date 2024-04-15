package com.example.facultades.service.model;

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
public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @Column(length = 1000) // Por ejemplo, aquí estamos especificando una longitud máxima de 1000 caracteres
    private String imagen;
    private String direccion;
    @Column(length = 2000) // Por ejemplo, aquí estamos especificando una longitud máxima de 1000 caracteres
    private String descripcion;
    private String direccionWeb;

    @OneToMany()
    private List<Carrera> listaCarreras;

    @OneToMany()
    private List<Calificacion> listaCalificacion;

    @OneToMany()
    private List<Comentario> listaComentarios;



}
