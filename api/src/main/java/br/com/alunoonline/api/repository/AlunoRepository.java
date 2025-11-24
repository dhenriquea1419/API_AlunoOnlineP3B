package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByEmailAluno(String emailAluno);
}
