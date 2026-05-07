package com.raimondo.Eventracker.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raimondo.Eventracker.models.Evento;

@Repository
public interface EventoRepository extends MongoRepository<Evento, String>{

    List<Evento> findByActivoTrue();
} 
