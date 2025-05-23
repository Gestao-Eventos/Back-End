package com.api.gestaoeventos.controller;

import com.api.gestaoeventos.dto.ParticipanteDTO;
import com.api.gestaoeventos.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("participante")
public class ParticipanteController {


    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<ParticipanteDTO>> listarTodos() {
        return ResponseEntity.ok(participanteService.listarParticipante());
    }

    @PostMapping("/criar")
    public ResponseEntity<ParticipanteDTO> criar(@RequestBody ParticipanteDTO participanteDTO) {
        ParticipanteDTO novoParticipante = participanteService.criarParticipante(participanteDTO);
        return ResponseEntity.ok(novoParticipante);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ParticipanteDTO> atualizar(
            @PathVariable Long id,
            @RequestBody ParticipanteDTO participanteDTO) {
        ParticipanteDTO participanteAtualizado = participanteService.atualizarParticipante(id, participanteDTO);
        return ResponseEntity.ok(participanteAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        participanteService.deletarParticipante(id);
        return ResponseEntity.noContent().build();
    }

}
