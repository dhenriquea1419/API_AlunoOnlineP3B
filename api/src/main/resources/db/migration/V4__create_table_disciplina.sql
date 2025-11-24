CREATE TABLE IF NOT EXISTS disciplina (
    id_disciplina BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_disciplina VARCHAR(100) NOT NULL,
    carga_horaria INT NOT NULL,
    professor_id BIGINT,
    CONSTRAINT fk_professor_id
        FOREIGN KEY (professor_id)
        REFERENCES professor(id_professor)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);