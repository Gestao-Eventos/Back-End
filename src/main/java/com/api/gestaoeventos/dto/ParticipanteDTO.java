package com.api.gestaoeventos.dto;

import java.util.List;

import com.api.gestaoeventos.entity.Evento;
import com.api.gestaoeventos.entity.Participante;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

public class ParticipanteDTO {
	
	private Long id;
    @Column(nullable = false)
    @Size(max = 50, message = "Nome do participante não deve ultrapassar 50 caracteres.")
	private String nome;
    @Column(nullable = false)
    @Size(max = 100, message = "O campo email não deve ultrapassar.")
	private String email;
    @Column(nullable = false)
    @Size(min = 11, max = 11, message = "O campo telefone deve ter 11 caracteres.")
	private String telefone;

	public List<Long> eventos;
	
	public ParticipanteDTO() {
	}

	public ParticipanteDTO(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public ParticipanteDTO(Participante participante) {
		id = participante.getId();
		nome = participante.getNome();
		email = participante.getEmail();
		telefone = participante.getTelefone();
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

	public List<Long> getEventos() {
		return eventos;
	}

	public void setEventos(List<Long> eventos) {
		this.eventos = eventos;
	}

	

}
