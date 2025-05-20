package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    ProfessorRepository professorRepository;

    public void criarDisciplina(Disciplina disciplina) {
        if (disciplina.getProfessor() == null || disciplina.getProfessor().getIdProfessor() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor é obrigatório.");
        }

        Long idProfessor = disciplina.getProfessor().getIdProfessor();

        Professor professor = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado"));

        disciplina.setProfessor(professor);
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarDisciplinaPorIdProfessor(Long idProfessor) {
        return disciplinaRepository.findByProfessorIdProfessor(idProfessor);
    }

        public void deletarDisciplina(Long idDisciplina){
            Disciplina disciplina = disciplinaRepository.findById(idDisciplina)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada"));

            disciplinaRepository.delete(disciplina);
        }
    }






