package com.raimondo.Eventracker.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.raimondo.Eventracker.models.Evento;
import com.raimondo.Eventracker.repositories.EventoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventoSevice {

    private final EventoRepository eventoRepo;

    public Evento guardarEvento(Evento evento){

        if(evento.getNombre() == null || evento.getNombre().isEmpty()){
            throw new RuntimeException("No podemos guardar un evento sin nombre");
        }
        evento.setActivo(true);
        evento.setFechaObtencion(LocalDateTime.now());
        evento.setEsDuplicado(false);
        evento.setEsRevidoPorIa(false);
        return eventoRepo.save(evento);
    }

    //Borrado Lógico del evento
    public String borrarEvento(String id){

        Evento evento = eventoRepo.findById(id).orElseThrow(()-> new RuntimeException( "El evento no esta registrado en la base de datos"));
        evento.setActivo(false);
        eventoRepo.save(evento);
        return "Se ha borrado exitosamente el evento";
    }

    //lista de eventos activos
    public List<Evento> traerEventosActivos(){
       return eventoRepo.findByActivoTrue();
    }

    //editar datos del evento

    public Evento editarEvento(String id, Evento evento){
        Evento eventoEncontrado = eventoRepo.findById(id).orElseThrow(()-> new RuntimeException("El id del evento ingresado no existe"));
        eventoEncontrado.setNombre(evento.getNombre());
        eventoEncontrado.setUbicacion(evento.getUbicacion());
        eventoEncontrado.setCategoria(evento.getCategoria());
        eventoEncontrado.setFuente(evento.getFuente());
        eventoEncontrado.setFechaEvento(evento.getFechaEvento());

        return eventoRepo.save(eventoEncontrado);
    }
}
