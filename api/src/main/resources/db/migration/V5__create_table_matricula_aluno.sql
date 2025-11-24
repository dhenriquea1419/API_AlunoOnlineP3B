CREATE TABLE matricula_aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    aluno_id BIGINT,
    disciplina_id BIGINT,

    nota1 DOUBLE,
    nota2 DOUBLE,

    status VARCHAR(50),

    CONSTRAINT fk_aluno_id
        FOREIGN KEY (aluno_id)
        REFERENCES aluno(id_aluno)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_disciplina_id
        FOREIGN KEY (disciplina_id)
        REFERENCES disciplina(id_disciplina)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);