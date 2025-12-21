-- Cria o banco todolist se não existir
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'todolist')
BEGIN
    CREATE DATABASE todolist;
END
GO

-- Usa o banco todolist
USE todolist;
GO

-- Cria a tabela tarefa
IF NOT EXISTS (
    SELECT * FROM sys.tables WHERE name = 'tarefa'
)
BEGIN
    CREATE TABLE tarefa (
        id INT IDENTITY(1,1) PRIMARY KEY,
        titulo VARCHAR(150) NOT NULL,
        descricao VARCHAR(500),
        data_criacao DATETIME NOT NULL,
        status VARCHAR(20) NOT NULL
            CHECK (status IN ('PENDENTE', 'EM_ANDAMENTO', 'CONCLUIDA'))
    );
END
GO