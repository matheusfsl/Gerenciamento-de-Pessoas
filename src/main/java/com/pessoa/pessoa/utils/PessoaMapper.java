package com.pessoa.pessoa.utils;

import com.pessoa.pessoa.dto.request.PessoaForm;
import com.pessoa.pessoa.dto.response.PessoaDto;
import com.pessoa.pessoa.model.PessoaModel;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    public PessoaModel formToModel (PessoaForm pessoaForm){
        if (pessoaForm == null){
            return null;
        }

        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setName(pessoaForm.getName());
        pessoaModel.setSobrenome(pessoaForm.getSobrenome());
        pessoaModel.setCpf(pessoaForm.getCpf());
        pessoaModel.setEmail(pessoaForm.getEmail());
        pessoaModel.setAltura(pessoaForm.getAltura());
        pessoaModel.setPeso(pessoaForm.getPeso());
        pessoaModel.setIdade(pessoaForm.getIdade());
        pessoaModel.setCorFavorita(pessoaForm.getCorFavorita());
        pessoaModel.setEstadoCivil(pessoaForm.getEstadoCivil());
        pessoaModel.setSalario(pessoaForm.getSalario());
        pessoaModel.setSexo(pessoaForm.getSexo());
        pessoaModel.setProfissao(pessoaForm.getProfissao());
        pessoaModel.setIdade(pessoaForm.getIdade());
        pessoaModel.setActive(true);

        return pessoaModel;

    }

    public PessoaDto modelToDto (PessoaModel pessoaModel){
        PessoaDto pessoaDto = new PessoaDto();

        pessoaDto.setName(pessoaModel.getName());
        pessoaDto.setSobrenome(pessoaModel.getSobrenome());
        pessoaDto.setCpf(pessoaModel.getCpf());
        pessoaDto.setIdade(pessoaModel.getIdade());
        pessoaDto.setSalario(pessoaModel.getAltura());
        pessoaDto.setAltura(pessoaModel.getAltura());
        pessoaDto.setProfissao(pessoaModel.getProfissao());
        pessoaDto.setPeso(pessoaModel.getPeso());
        pessoaDto.setEmail(pessoaDto.getEmail());
        pessoaDto.setSexo(pessoaModel.getSexo());
        pessoaDto.setIdade(pessoaModel.getIdade());
        pessoaDto.setCorFavorita(pessoaModel.getCorFavorita());
        pessoaDto.setEstado(pessoaModel.getEstado());

        return pessoaDto;
    }

    public PessoaModel updateFormToModel (PessoaForm pessoaForm, PessoaModel pessoaModel){
        pessoaModel.setName(pessoaForm.getName());
        pessoaModel.setSobrenome(pessoaForm.getSobrenome());
        pessoaModel.setCpf(pessoaForm.getCpf());
        pessoaModel.setEmail(pessoaForm.getEmail());
        pessoaModel.setAltura(pessoaForm.getAltura());
        pessoaModel.setPeso(pessoaForm.getPeso());
        pessoaModel.setIdade(pessoaForm.getIdade());
        pessoaModel.setCorFavorita(pessoaForm.getCorFavorita());
        pessoaModel.setEstadoCivil(pessoaForm.getEstadoCivil());
        pessoaModel.setSalario(pessoaForm.getSalario());
        pessoaModel.setSexo(pessoaForm.getSexo());
        pessoaModel.setProfissao(pessoaForm.getProfissao());
        pessoaModel.setIdade(pessoaForm.getIdade());

        return pessoaModel;
    }

   public Set<PessoaDto> setModelToSetDto(Set<PessoaModel> pessoaModels){
        if (pessoaModels == null || pessoaModels.isEmpty()){
            return Collections.emptySet();
        }
        return pessoaModels.stream()
                .map(this::modelToDto)
                .collect(Collectors.toSet());
   }

}
