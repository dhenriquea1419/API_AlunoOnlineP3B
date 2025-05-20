package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void createAluno(Aluno aluno){

        alunoRepository.save(aluno);
    }

    public List<Aluno> listAllAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> searchAlunoById(Long idAluno){
        return alunoRepository.findById(idAluno);
    }

    public void deleteAlunoById(Long idAluno){
        alunoRepository.deleteById(idAluno);
    }

    public void updateAlunoById(Long idAluno, Aluno aluno){
        Optional<Aluno> alunoDataBase = searchAlunoById(idAluno);

        if (alunoDataBase.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado do banco de dados");
        }

        Aluno alunoEdit = alunoDataBase.get();

        alunoEdit.setNomeAluno(aluno.getNomeAluno());
        alunoEdit.setCpfAluno(aluno.getCpfAluno());
        alunoEdit.setEmailAluno(aluno.getEmailAluno());

        alunoRepository.save(alunoEdit);
    }

}
