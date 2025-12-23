package com.stefanini.todolist.application.dto;

import java.sql.Date;

import com.stefanini.todolist.domain.enums.TarefaStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TarefaResponseDTO {
	private String titulo;
	private String descricao;
	private Date dataCriacao;
	private TarefaStatus status;
}
