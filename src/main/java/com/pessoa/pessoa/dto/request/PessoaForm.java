package com.pessoa.pessoa.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaForm {

    @NotBlank(message = "esse campo não pode estar vazio" )
    @Size(min = 2, max = 100, message = "name must be between {min} and {max} character")
    private String name;

    @NotBlank(message = "esse campo não pode estar vazio" )
    @Size(min = 2, max = 100, message = "sobrenome must be between {min} and {max} character")
    private String sobrenome;

    @NotNull(message = "esse campo não pode estar vazio")
    @Min(value = 0, message = "a idade não pode ser um número negativo")
    private int idade;

    @NotNull(message = "esse campo não pode estar vazio")
    @Min(value = 0, message = "a idade não pode ser um número negativo")
    private double altura;

    @NotNull(message = "esse campo não pode estar vazio")
    @Min(value = 0, message = "a idade não pode ser um número negativo")
    private double peso;

    @NotBlank(message = "esse campo não pode estar vazio")
    @Size(min = 11, max = 11, message = "cpf must be between {min} and {max} character")
    private String cpf;

    @NotBlank(message = "esse campo não pode estar vazio")
    @Size(min = 2, max = 100, message = "estado must be between {min} and {max} character")
    private String estado;

    @NotBlank(message = "esse campo não pode estar vazio")
    @Size(min = 2, max = 100, message = "email must be between {min} and {max} character")
    private String email;

    @NotBlank(message = "esse campo não pode estar vazio")
    @Size(min = 2, max = 100, message = "cor favorita must be between {min} and {max} character")
    private String corFavorita;

    @NotBlank(message = "esse campo não pode estar vazio")
    @Size(min = 2, max = 100, message = " sexo must be between {min} and {max} character")
    private String sexo;

    @NotBlank(message = "esse campo não pode estar vazio")
    @Size(min = 2, max = 100, message = "estado civil must be between {min} and {max} character")
    private String estadoCivil;

    @NotBlank(message = "esse campo não pode estar vazio")
    @Size(min = 2, max = 100, message = "salario must be between {min} and {max} character")
    private double salario;

    @NotBlank(message = "esse campo não pode estar vazio")
    @Size(min = 2, max = 100, message = "profissão must be between {min} and {max} character")
    private String profissao;


}
