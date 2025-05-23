package com.api.gestaoeventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.gestaoeventos.dto.EventoDTO;
import com.api.gestaoeventos.services.EventoService;
import java.util.List;

@RestController
@RequestMapping("evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listarTodos() {
        return ResponseEntity.ok(eventoService.listarEventos());
    }

    @PostMapping("/criar")
    public ResponseEntity<EventoDTO> criar(@RequestBody EventoDTO eventoDTO) {
        return ResponseEntity.ok(eventoService.criarEvento(eventoDTO));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EventoDTO> atualizar(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {
        return ResponseEntity.ok(eventoService.atualizarEvento(id, eventoDTO));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }
}
