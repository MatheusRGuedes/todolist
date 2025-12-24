package com.stefanini.todolist.presentation.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.todolist.application.dto.CreateTarefaDTO;
import com.stefanini.todolist.application.dto.TarefaResponseDTO;
import com.stefanini.todolist.application.service.CreateTarefaUseCase;
import com.stefanini.todolist.infrastructure.mapper.TarefaMapper;

import jakarta.validation.Valid;
 
@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired 
	private CreateTarefaUseCase createTarefaUseCase;
	@Autowired 
	private TarefaMapper mapper;

	@PostMapping 
	public ResponseEntity<TarefaResponseDTO> create(
			@RequestBody @Valid CreateTarefaDTO request) { 
		TarefaResponseDTO tarefaResponse = mapper.toResponse(createTarefaUseCase.execute(request));
		return ResponseEntity.ok(tarefaResponse); 
	}	
}
