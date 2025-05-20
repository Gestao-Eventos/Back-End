package com.api.gestaoeventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaoeventos.entity.Evento;
import com.api.gestaoeventos.entity.Participante;
import com.api.gestaoeventos.repository.EventoRepository;
import com.api.gestaoeventos.repository.ParticipanteRepository;

@Service
public class InscricaoService {
	@Autowired
	ParticipanteRepository participanteRepository;
	@Autowired
	EventoRepository eventoRepository;
	
	public void associar(Long idParticipante, Long idEvento) {
		Participante participante = participanteRepository
				.findById(idParticipante).orElseThrow(() -> new RuntimeException("Id do participante não encontrado."));
		Evento evento = eventoRepository
				.findById(idEvento).orElseThrow(() -> new RuntimeException("Id do evento não encontrado."));
		participante.getEventos().add(evento);
		evento.getParticipantes().add(participante);
		
		participanteRepository.save(participante);
		eventoRepository.save(evento);
	}
	
}
