package com.api.gestaoeventos.entity;

import java.time.LocalDate;
import java.util.List;

import com.api.gestaoeventos.dto.EventoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(length = 255)
    private String descricao;
    @Column(nullable = false, length = 100)
    private String local;
    @Column(nullable = false)
    private Integer vagas;
    private LocalDate data;


    @ManyToMany
    @JoinTable(name = "tb_evento_participante",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "pariticipante_id"))

    private List<Participante> participantes;

    public Evento() {
    }

    public Evento(String nome, String descricao, String local, Integer vagas, LocalDate data) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.vagas = vagas;
        this.data = data;
    }
    
    public Evento(EventoDTO eventoDTO) {
    	id = eventoDTO.getId();
    	nome = eventoDTO.getNome();
		descricao = eventoDTO.getDescricao();
		local = eventoDTO.getLocal();
		vagas = eventoDTO.getVagas();
		data = eventoDTO.getData();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
