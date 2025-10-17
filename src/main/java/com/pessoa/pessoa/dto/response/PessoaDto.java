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
    private int idade;
    private double altura;
    private double peso;
    private String estado;
    private String email;


}
