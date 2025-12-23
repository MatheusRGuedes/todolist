package com.stefanini.todolist.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stefanini.todolist.domain.entity.Tarefa;

public interface TarefaRepository {

	public List<Tarefa> listAll();
	
	public Tarefa find(Long id);
	
	public Tarefa save(Tarefa tarefa);
	
	public Tarefa update(Long id);
	
	public void delete(Long id);
}
