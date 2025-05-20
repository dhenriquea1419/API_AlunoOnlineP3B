package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long idProfessor;

    @Column(name = "nome_professor")
    private String nomeProfessor;

    @Column(name = "email_professor")
    private String emailProfessor;

    @Column(name = "cpf_professor")
    private String cpfProfessor;
}
