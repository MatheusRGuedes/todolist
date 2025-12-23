package com.stefanini.todolist.domain.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DataBaseConnection {

    private static DataBaseConnection instace;

    private final Connection connection;

    private DataBaseConnection() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=todolist;encrypt=true;trustServerCertificate=true", "sa", "Senha123");
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao se conectar com banco de dados!");
        }
    }

    public static DataBaseConnection getInstance() {
        if (Objects.isNull(instace)) {
            instace = new DataBaseConnection();
        }
        return instace;
    }

    public Connection connection() {
        return connection;
    }
}