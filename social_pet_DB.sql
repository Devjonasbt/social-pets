CREATE DATABASE cadastro CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE cadastrar (
	id int auto_increment,
    nome VARCHAR(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    data VARCHAR(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    email VARCHAR(50),
	nomePai VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    nomeMae VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    senha VARCHAR(50),
    repSenha VARCHAR(50)
);

select * from cadastrar;