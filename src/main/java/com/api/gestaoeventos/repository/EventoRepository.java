package com.api.gestaoeventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestaoeventos.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento , Long> {

}
