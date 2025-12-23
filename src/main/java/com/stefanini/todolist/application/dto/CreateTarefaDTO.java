package com.stefanini.todolist.application.dto;

import org.hibernate.validator.constraints.Length;

import com.stefanini.todolist.domain.enums.TarefaStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTarefaDTO {
	@NotBlank(message = "O titulo é obrigatório.")
	@Length(max = 150)
	private String titulo;
	@Length(max = 500)
	private String descricao;
	@NotNull(message = "O status da tarefa é obrigatório.")
	private TarefaStatus status;
}
