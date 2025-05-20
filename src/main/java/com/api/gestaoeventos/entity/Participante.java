package com.api.gestaoeventos.entity;

import jakarta.persistence.*;

import java.util.Set;

import com.api.gestaoeventos.dto.ParticipanteDTO;

import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "tb_participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 11)
    private String telefone;

    @ManyToMany(mappedBy = "participantes")
    private List<Evento> eventos;

    public Participante() {
    }

    public Participante(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
    public Participante(ParticipanteDTO participanteDTO) {
    	id = participanteDTO.getId();
    	nome = participanteDTO.getNome();
    	email = participanteDTO.getEmail();
    	telefone = participanteDTO.getTelefone();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
