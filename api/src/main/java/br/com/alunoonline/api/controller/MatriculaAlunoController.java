package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dto.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.dto.HistoricoAlunoResponseDTO;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarMatricula(@RequestBody MatriculaAluno matriculaAluno){
        matriculaAlunoService.criarMatricula(matriculaAluno);
    }

    @PatchMapping("/trancar/{idMatricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void trancarMatricula(@PathVariable Long idMatricula) {
        matriculaAlunoService.trancarMatricula(idMatricula);
    }

    @PatchMapping("/atualiza-notas/{idMatricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaNotas(@RequestBody AtualizarNotasRequestDTO request,
                              @PathVariable Long idMatricula)
    {
        matriculaAlunoService.atualizarNotas(request, idMatricula);
    }

    @GetMapping("/emitir-historico/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoResponseDTO emitirHistorico(@PathVariable Long alunoId) {
        return matriculaAlunoService.emitirHistorico(alunoId);
    }


}