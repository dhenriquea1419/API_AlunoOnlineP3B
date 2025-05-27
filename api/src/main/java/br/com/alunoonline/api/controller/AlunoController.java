package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// indica que essa classe é um controlador REST e que os métodos retornam dados JSON.
@RequestMapping("/alunos")
//define a rota base para todos os métodos, ou seja, todas as URLs começam com /alunos.
public class AlunoController {

    @Autowired
    AlunoService alunoService;
    //Injeta a dependência do AlunoService automaticamente para que possamos chamar métodos do serviço dentro do controller.

    @PostMapping
    //mapeia requisições HTTP POST para este método, que cria um novo recurso.
    @ResponseStatus(HttpStatus.CREATED)
    //retorna código HTTP 201 para indicar que o recurso foi criado com sucesso.

    public void createAluno(@RequestBody Aluno aluno){
        alunoService.createAluno(aluno);
        //pega o JSON do corpo da requisição e transforma num objeto Aluno.
        //Dentro do método, chama o serviço para salvar esse aluno no banco.
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //Código HTTP 200 (OK) padrão.
    public List<Aluno> listAllAlunos(){

        return alunoService.listAllAlunos();
    }

    @GetMapping("/{idAluno}")
    //rota GET com parâmetro dinâmico idAluno.
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> searchAlunoById(@PathVariable Long idAluno){
        // @PathVariable Long idAluno: extrai o valor do parâmetro da URL.

        return alunoService.searchAlunoById(idAluno);
        //Retorna um objeto Optional<Aluno>, que pode conter o aluno se encontrado ou vazio se não existir.
    }

    @DeleteMapping("/{idAluno}")
    //mapeia requisições DELETE para remover aluno.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //Retorna HTTP 204 (NO_CONTENT), pois não retorna corpo, apenas indica sucesso na exclusão.
    public void deleteAlunoById(@PathVariable Long idAluno){
        alunoService.deleteAlunoById(idAluno);
    }

    @PutMapping("/{idAluno}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAluno (@PathVariable Long idAluno, @RequestBody Aluno aluno){
        alunoService.updateAlunoById(idAluno, aluno);
    }
}
