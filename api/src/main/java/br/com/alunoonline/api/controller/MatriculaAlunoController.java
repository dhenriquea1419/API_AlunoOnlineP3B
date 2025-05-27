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
    // responde a requisições POST para criar uma matrícula.
    @ResponseStatus(HttpStatus.CREATED)
    //Retorna status 201 (Created).
    public void criarMatricula(@RequestBody MatriculaAluno matriculaAluno){
        matriculaAlunoService.criarMatricula(matriculaAluno);
    }

    @PatchMapping("/trancar/{idMatricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //Retorna HTTP 204 (No Content).
    public void trancarMatricula(@PathVariable Long idMatricula) {
        matriculaAlunoService.trancarMatricula(idMatricula);
        //Chama o serviço que faz a validação e altera o status para "trancado".
    }

    @PatchMapping("/atualiza-notas/{idMatricula}")
    //PATCH para atualizar notas da matrícula com ID recebido na URL.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //Retorna HTTP 204.
    public void atualizaNotas(@RequestBody AtualizarNotasRequestDTO request,
                              @PathVariable Long idMatricula)
            //Recebe o DTO AtualizarNotasRequestDTO que contém as notas no corpo da requisição.
    {
        matriculaAlunoService.atualizarNotas(request, idMatricula);
    }

    @GetMapping("/emitir-historico/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    //Status HTTP 200 OK.
    public HistoricoAlunoResponseDTO emitirHistorico(@PathVariable Long alunoId) {
        return matriculaAlunoService.emitirHistorico(alunoId);
    }


}
