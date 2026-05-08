package com.raimondo.Eventracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.raimondo.Eventracker.models.Evento;
import com.raimondo.Eventracker.services.EventoSevice;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/evento")
@RequiredArgsConstructor
public class EventoController {
    
    private final EventoSevice eventoService;
    

    @PostMapping("/crear")
    public Evento crearEvento(@RequestBody Evento evento){        
        return eventoService.guardarEvento(evento);
    }

    @PutMapping("/editar/{id}")
    public Evento editarEvento(@PathVariable String id, @RequestBody Evento evento){
        return eventoService.editarEvento(id, evento);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarEvento(@PathVariable String id){
        return eventoService.borrarEvento(id);
    }

    
    @GetMapping("/listar")
    public List<Evento> listarEventos(){
        return eventoService.traerEventosActivos();
    }
}
