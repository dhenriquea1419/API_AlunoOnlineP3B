package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Importa anotações JPA para persistência de dados (@Entity, @Table, etc.).
//Importa anotações Lombok para gerar automaticamente construtores, getters/setters e outros métodos.
@Entity //Indica que essa classe é uma entidade JPA que será mapeada para uma tabela no banco de dados.
@Data //Lombok gera getters, setters, toString, equals e hashCode automaticamente.
@AllArgsConstructor //Lombok gera construtor com todos os campos.
@NoArgsConstructor //Lombok gera construtor vazio padrão.
@Table(name = "disciplina") //Especifica o nome da tabela no banco.

public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    //mapeia o campo para a coluna nome_disciplina na tabela.
    private Long idDisciplina;

    @Column(name = "nome_disciplina")
    private String nomeDisciplina;


    private Integer cargaHoraria;
    //Armazena a carga horária da disciplina.

    @ManyToOne
    //Relação muitos-para-um, indica que várias disciplinas podem ter o mesmo professor.
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
