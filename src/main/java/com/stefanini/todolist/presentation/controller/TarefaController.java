package com.stefanini.todolist.presentation.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.todolist.application.dto.CreateTarefaDTO; 
import com.stefanini.todolist.application.service.CreateTarefaUseCase;
import com.stefanini.todolist.domain.entity.Tarefa;

import jakarta.validation.Valid;
 
@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private CreateTarefaUseCase createTarefaUseCase;
	
	@PostMapping
	public ResponseEntity<Tarefa> create(@RequestBody @Valid CreateTarefaDTO request) {
		Tarefa tarefa = createTarefaUseCase.execute(request);
		return ResponseEntity.ok(tarefa);
	}
}
