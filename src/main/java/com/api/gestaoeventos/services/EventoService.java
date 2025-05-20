package com.api.gestaoeventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaoeventos.dto.EventoDTO;
import com.api.gestaoeventos.entity.Evento;
import com.api.gestaoeventos.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	 EventoRepository eventoRepository;

	public List<EventoDTO> listarEventos(){
		return eventoRepository.findAll().stream().map(EventoDTO::new).toList();
	}

    public EventoDTO criarEvento(EventoDTO eventoDTO) {
        Evento evento = new Evento(eventoDTO);

        return new EventoDTO(eventoRepository.save(evento));
    }

    public EventoDTO atualizarEvento(Long id, EventoDTO eventoDTO) {
        Evento evento = eventoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        evento.setNome(eventoDTO.getNome());
        evento.setDescricao(eventoDTO.getDescricao());
        evento.setLocal(eventoDTO.getLocal());
        evento.setData(eventoDTO.getData());
        evento.setVagas(eventoDTO.getVagas());

        return new EventoDTO(eventoRepository.save(evento));

    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
	
	
}
