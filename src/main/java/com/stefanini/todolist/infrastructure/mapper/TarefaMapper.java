package com.stefanini.todolist.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.stefanini.todolist.application.dto.CreateTarefaDTO;
import com.stefanini.todolist.application.dto.TarefaResponseDTO;
import com.stefanini.todolist.domain.entity.Tarefa;
 
@Mapper(componentModel = "spring")
public interface TarefaMapper {

	@Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
	Tarefa toEntity(CreateTarefaDTO createTarefaDTO);

	TarefaResponseDTO toResponse(Tarefa tarefa);
	/*
	 * 
	 * 
	 * List<JogadorDTO> toResponseList(List<Jogador> jogadores);
	 */
}
