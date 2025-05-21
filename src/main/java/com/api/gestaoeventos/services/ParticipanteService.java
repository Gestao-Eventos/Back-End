package com.api.gestaoeventos.services;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaoeventos.dto.ParticipanteDTO;
import com.api.gestaoeventos.entity.Participante;
import com.api.gestaoeventos.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;


    public List<ParticipanteDTO> listarParticipante() {
        return participanteRepository.findAll().stream().map(ParticipanteDTO::new).toList();
    }

    @Transactional

    public ParticipanteDTO criarParticipante(ParticipanteDTO participanteDTO) {
        Participante participante = new Participante(participanteDTO);

        return new ParticipanteDTO(participanteRepository.save(participante));
    }

    @Transactional
    public ParticipanteDTO atualizarParticipante(Long id, ParticipanteDTO participanteDTO) {
        Participante participante = participanteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Participante não encontrado."));

        participante.setEmail(participanteDTO.getEmail());
        participante.setNome(participanteDTO.getNome());
        participante.setTelefone(participanteDTO.getTelefone());

        return new ParticipanteDTO(participanteRepository.save(participante));

    }

    @Transactional
    public void deletarParticipante(Long id) {
        participanteRepository.deleteById(id);
    }


}
