package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAluno(@RequestBody Aluno aluno){
        alunoService.createAluno(aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listAllAlunos(){

        return alunoService.listAllAlunos();
    }

    @GetMapping("/{idAluno}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> searchAlunoById(@PathVariable Long idAluno){

        return alunoService.searchAlunoById(idAluno);
    }

    @DeleteMapping("/{idAluno}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlunoById(@PathVariable Long idAluno){
        alunoService.deleteAlunoById(idAluno);
    }

    @PutMapping("/{idAluno}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAluno (@PathVariable Long idAluno, @RequestBody Aluno aluno){
        alunoService.updateAlunoById(idAluno, aluno);
    }
}
