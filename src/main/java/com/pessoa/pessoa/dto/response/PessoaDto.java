package com.pessoa.pessoa.dto.response;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    private String name;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private String cpf;
    private String estado;
    private String email;
    private String corFavorita;
    private String sexo;
    private String estadoCivil;
    private double salario;
    private String profissao;

}
