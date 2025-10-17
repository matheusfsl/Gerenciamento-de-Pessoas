package com.pessoa.pessoa.utils;

import com.pessoa.pessoa.dto.request.PessoaForm;
import com.pessoa.pessoa.dto.response.PessoaDto;
import com.pessoa.pessoa.model.PessoaModel;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.Collections;
import java.util.List;
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
        pessoaModel.setEmail(pessoaForm.getEmail());
        pessoaModel.setAltura(pessoaForm.getAltura());
        pessoaModel.setPeso(pessoaForm.getPeso());
        pessoaModel.setIdade(pessoaForm.getIdade());
        pessoaModel.setEstado(pessoaForm.getEstado());
        pessoaModel.setActive(true);

        return pessoaModel;

    }

    public PessoaDto modelToDto (PessoaModel pessoaModel){
        PessoaDto pessoaDto = new PessoaDto();

        pessoaDto.setName(pessoaModel.getName());
        pessoaDto.setIdade(pessoaModel.getIdade());
        pessoaDto.setAltura(pessoaModel.getAltura());
        pessoaDto.setPeso(pessoaModel.getPeso());
        pessoaDto.setEmail(pessoaModel.getEmail());
        pessoaDto.setEstado(pessoaModel.getEstado());


        return pessoaDto;
    }

    public PessoaModel updateFormToModel (PessoaForm pessoaForm, PessoaModel pessoaModel){
        pessoaModel.setName(pessoaForm.getName());
        pessoaModel.setEmail(pessoaForm.getEmail());
        pessoaModel.setAltura(pessoaForm.getAltura());
        pessoaModel.setPeso(pessoaForm.getPeso());
        pessoaModel.setIdade(pessoaForm.getIdade());
        pessoaModel.setEstado(pessoaForm.getEstado());

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

    public List<PessoaDto> setListModelToSetDto(List<PessoaModel> pessoaModels){
        if (pessoaModels == null || pessoaModels.isEmpty()){
            return Collections.emptyList();
        }
        return pessoaModels.stream()
                .map(this::modelToDto)
                .toList();
    }

}
