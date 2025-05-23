package com.api.gestaoeventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestaoeventos.entity.Participante;
 
@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

}
