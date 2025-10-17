package com.pessoa.pessoa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa")
public class PessoaModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name="altura", nullable = false)
    private double altura;

    @Column(name="peso", nullable = false)
    private double peso;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "isActive", nullable = false)
    private boolean isActive;
}
