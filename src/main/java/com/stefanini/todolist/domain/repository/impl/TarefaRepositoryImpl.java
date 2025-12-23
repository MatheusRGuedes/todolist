package com.stefanini.todolist.domain.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stefanini.todolist.domain.connection.DataBaseConnection;
import com.stefanini.todolist.domain.entity.Tarefa;
import com.stefanini.todolist.domain.enums.TarefaStatus;
import com.stefanini.todolist.domain.repository.TarefaRepository;

@Repository
public class TarefaRepositoryImpl implements TarefaRepository {

	@Override
	public List<Tarefa> listAll() {
		List<Tarefa> tarefas = new ArrayList<>();

       Connection connection = DataBaseConnection.getInstance().connection();

       final String sql = """
         		SELECT titulo, descricao, data_criacao, status FROM tarefa
         		""";
       
       try (PreparedStatement pstmt = connection.prepareStatement(sql)){
    	   ResultSet resultSet = pstmt.executeQuery();
           while (resultSet.next()) { 
        	   String titulo = resultSet.getString("titulo");
               String descricao = resultSet.getString("descricao");
               Date dataCriacao = resultSet.getDate("data_criacao");
               String status = resultSet.getString("status");

               tarefas.add(new Tarefa(null, titulo, descricao, dataCriacao, TarefaStatus.valueOf(status)));
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return tarefas;
	}

	@Override
	public Tarefa save(final Tarefa tarefa) {	 
		
		Connection connection = DataBaseConnection.getInstance().connection();
        	 
        final String sql = """
              		INSERT INTO TAREFA (titulo, descricao, data_criacao, status) 
              		VALUES(?, ?, ?, ?)
              		""";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
             pstmt.setString(1, tarefa.getTitulo());
             pstmt.setString(2, tarefa.getDescricao());
             pstmt.setDate(3, tarefa.getDataCriacao());
             pstmt.setString(4, tarefa.getStatus().toString());
             
             int count = pstmt.executeUpdate();
             if (count > 0) {
                 ResultSet generatedKeys = pstmt.getGeneratedKeys();
                 if (generatedKeys.next()) {
                 	long id = generatedKeys.getLong(1);
                    tarefa.setId(id);
                 }
             }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tarefa;
	}

	@Override
	public Tarefa update(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tarefa find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
