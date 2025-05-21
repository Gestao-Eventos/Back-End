package com.api.gestaoeventos.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaoeventos.entity.Evento;
import com.api.gestaoeventos.entity.Participante;
import com.api.gestaoeventos.repository.EventoRepository;
import com.api.gestaoeventos.repository.ParticipanteRepository;

@Service
public class InscricaoService {
    @Autowired
    private ParticipanteRepository participanteRepository;
    @Autowired
    private EventoRepository eventoRepository;

    @Transactional
    public String inscrever(Long idParticipante, Long idEvento) {
        Evento evento = eventoRepository
            .findById(idEvento).orElseThrow(() -> new RuntimeException("Id do evento não encontrado."));


        Participante participante = participanteRepository
            .findById(idParticipante).orElseThrow(() -> new RuntimeException("Id do participante não encontrado."));

        if (evento.getParticipantes().contains(participante)) {
            throw new RuntimeException("Já inscrito no evento.");
        } else if (evento.getVagas() <= 0) {
            throw new RuntimeException("Não há mais vagas disponíveis.");

        }


        participante.getEventos().add(evento);
        evento.getParticipantes().add(participante);

        evento.setVagas(evento.getVagas()-1);

        participanteRepository.save(participante);
        eventoRepository.save(evento);

        return "Inscrição realizada com sucesso!";
    }

}
