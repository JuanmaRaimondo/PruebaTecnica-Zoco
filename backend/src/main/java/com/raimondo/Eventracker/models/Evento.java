package com.raimondo.Eventracker.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "eventos_bares")
public class Evento {

    @Id
    private String id;
    private String nombre;
    private String ubicacion;
    private String categoria;
    private String fuente;
    private LocalDate fechaEvento;
    private LocalDateTime fechaObtencion;
    private Boolean activo; 
    private Boolean esRevidoPorIa;
    private Boolean esDuplicado;
}
