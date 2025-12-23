package com.stefanini.todolist;
 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stefanini.todolist.domain.connection.DataBaseConnection;
import com.stefanini.todolist.domain.entity.Tarefa;
import com.stefanini.todolist.domain.enums.TarefaStatus;
import com.stefanini.todolist.domain.repository.TarefaRepository;
import com.stefanini.todolist.domain.repository.impl.TarefaRepositoryImpl;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
		
		List<Tarefa> tarefas = new ArrayList<>();

		Tarefa tarefa = new Tarefa(null, "titulo 4", "excluir dados", new Date(new java.util.Date().getTime()), TarefaStatus.PENDENTE);
		
		TarefaRepositoryImpl repository = new TarefaRepositoryImpl();
		repository.save(tarefa);
	}
}
