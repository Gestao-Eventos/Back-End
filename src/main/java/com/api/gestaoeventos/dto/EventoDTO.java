package com.api.gestaoeventos.dto;

import java.time.LocalDate;
import java.util.List;

import com.api.gestaoeventos.entity.Evento;
import com.api.gestaoeventos.entity.Participante;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;Value;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

public class EventoDTO {
    private Long id;
    @Column(nullable = false)
    @Size(max = 100, message = "Nome do evento não deve ultrapassar 100 caracteres.")
    private String nome;
    @Size(max = 255, message = "Descrição do evento não deve ultrapassar 255 caracteres.")
    private String descricao;
    @Column(nullable = false)
    @Size(max = 100, message = "O nome do local não deve ultrapassar 100 caracteres.")
    private String local;
   
 
    private Integer vagas;
  
   
    private LocalDate data;
    
    public List<Long> participantes;
    
    
	public EventoDTO() {
		 
	}
 
	public EventoDTO(String nome, String descricao, String local, Integer vagas, LocalDate data) {
	 		this.nome = nome;
		this.descricao = descricao;
		this.local = local;
		this.vagas = vagas;
		this.data = data;
	}
	public EventoDTO(Evento evento) {
		 
		id = evento.getId();
		nome = evento.getNome();
		descricao = evento.getDescricao();
		local = evento.getLocal();
		vagas = evento.getVagas();
		data = evento.getData();
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

	public List<Long> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Long> participantes) {
		this.participantes = participantes;
	}

	
	
}
