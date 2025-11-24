CREATE TABLE professor (
    id_professor BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_professor VARCHAR(255) NOT NULL,
    email_professor VARCHAR(255) NOT NULL UNIQUE,
    cpf_professor VARCHAR(11) NOT NULL UNIQUE
);
