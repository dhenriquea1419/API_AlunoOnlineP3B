package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Ajuda o Spring a identificar essa interface como repositório.
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>
//Herda automaticamente métodos como save(), findAll(), findById(), deleteById(), etc.
{
    List<Disciplina> findByProfessorIdProfessor(Long idProfessor);

}

