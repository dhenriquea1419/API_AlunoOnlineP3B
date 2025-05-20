package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dto.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.dto.DisciplinasAlunoResponseDTO;
import br.com.alunoonline.api.dto.HistoricoAlunoResponseDTO;
import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaAlunoService {

    public static final Double MEDIA_PARA_APROVACAO = 7.0;
    private static final Integer QTD_NOTAS =  2;

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    public void criarMatricula(MatriculaAluno matriculaAluno){
        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public void trancarMatricula(Long idMatricula){
        MatriculaAluno matriculaAluno = matriculaAlunoRepository.findById(idMatricula).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada"));

        if (!MatriculaAlunoStatusEnum.MATRICULADO.equals(matriculaAluno.getStatus())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Só é possível trancar uma matricula com o status MATRICULADO");
        }

        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public void atualizarNotas(AtualizarNotasRequestDTO request, Long idMatricula){
        MatriculaAluno matriculaAluno = matriculaAlunoRepository.findById(idMatricula).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Matricula Aluno não encontrada!"));

        if (request.getNota1() != null) {
            matriculaAluno.setNota1(request.getNota1());
        }

        if (request.getNota2() != null) {
            matriculaAluno.setNota2(request.getNota2());
        }

        calculaMedia(matriculaAluno);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    private void calculaMedia(MatriculaAluno matriculaAluno) {
        Double nota1 = matriculaAluno.getNota1();
        Double nota2 = matriculaAluno.getNota2();

        if (nota1 != null && nota2 != null) {
            Double media = (nota1 + nota2) / QTD_NOTAS;
            matriculaAluno.setStatus(media >= MEDIA_PARA_APROVACAO ? MatriculaAlunoStatusEnum.APROVADO : MatriculaAlunoStatusEnum.REPROVADO);

        }
    }

    public HistoricoAlunoResponseDTO emitirHistorico(Long idAluno){
        List<MatriculaAluno> matriculasDoAluno = matriculaAlunoRepository.findByAlunoIdAluno(idAluno);

        if (matriculasDoAluno.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Esse aluno não possui matriculas");
        }

        HistoricoAlunoResponseDTO historicoAluno = new HistoricoAlunoResponseDTO();
        historicoAluno.setNomeAluno(matriculasDoAluno.get(0).getAluno().getNomeAluno());
        historicoAluno.setCpfAluno(matriculasDoAluno.get(0).getAluno().getCpfAluno());
        historicoAluno.setEmailAluno(matriculasDoAluno.get(0).getAluno().getEmailAluno());

        List<DisciplinasAlunoResponseDTO> displinasList = new ArrayList<>();

        for (MatriculaAluno matriculaAluno : matriculasDoAluno) {
            DisciplinasAlunoResponseDTO disciplinasAlunoResponse = new DisciplinasAlunoResponseDTO();
            disciplinasAlunoResponse.setNomeDisciplina(matriculaAluno.getDisciplina().getNomeDisciplina());
            disciplinasAlunoResponse.setNomeProfessor(matriculaAluno.getDisciplina().getProfessor().getNomeProfessor());
            disciplinasAlunoResponse.setNota1(matriculaAluno.getNota1());
            disciplinasAlunoResponse.setNota2(matriculaAluno.getNota2());

            if (matriculaAluno.getNota1() != null && matriculaAluno.getNota2() != null) {
                disciplinasAlunoResponse.setMedia((matriculaAluno.getNota1() + matriculaAluno.getNota2()) / 2.0);
            } else {
                disciplinasAlunoResponse.setMedia(null);
            }

            disciplinasAlunoResponse.setStatus(matriculaAluno.getStatus());

            displinasList.add(disciplinasAlunoResponse);
        }

        historicoAluno.setDisciplinasAlunoResponsesDTO(displinasList);

        return historicoAluno;
    }
}