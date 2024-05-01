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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;

    @OneToMany()
    private List<Universidad> listaUniversidad;

    @OneToMany()
    private List<Calificacion> listaCalificacion;

    @OneToMany()
    private List<Comentario> listaComentarios;

    @OneToMany()
    private  List<Respuesta> listaRespuesta;

    @OneToMany()
    private List<Reaccion> listaReaccion;

}
