package com.stefanini.todolist.application.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.todolist.application.dto.CreateTarefaDTO;
import com.stefanini.todolist.domain.entity.Tarefa;
import com.stefanini.todolist.domain.repository.TarefaRepository;

@Service
public class CreateTarefaUseCase {

	@Autowired
	private TarefaRepository repository;

    public Tarefa execute(CreateTarefaDTO request) {
    	
    	final Date dataAtual = new Date(new java.util.Date().getTime());
    	
    	final Tarefa user = new Tarefa(null, request.getTitulo(), request.getDescricao(), 
    			dataAtual, request.getStatus());
 
        final Tarefa tarefaCreated = repository.save(user);
         
        return tarefaCreated;
    }
	
}
