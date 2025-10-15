package com.pessoa.pessoa.service;

import com.pessoa.pessoa.dto.request.PessoaForm;
import com.pessoa.pessoa.dto.response.PessoaDto;
import com.pessoa.pessoa.exception.PessoaAlreadyExists;
import com.pessoa.pessoa.exception.PessoaInsertException;
import com.pessoa.pessoa.exception.PessoaNotFoundExeception;
import com.pessoa.pessoa.exception.PessoaUpdateException;
import com.pessoa.pessoa.model.PessoaModel;
import com.pessoa.pessoa.repository.PessoaRepository;
import com.pessoa.pessoa.utils.PessoaMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    public PessoaModel getPessoaModelByEmail(String email) {
        return pessoaRepository.findByEmailContainingIgnoreCase(email).
                orElseThrow(() -> new PessoaNotFoundExeception(
                        String.format("A Pessoa com o email '%s' não foi encontrada ", email)
                ));
    }

    public PessoaDto getPessoaByEmail(String email) {
        PessoaModel pessoaModel = getPessoaModelByEmail(email);
        return pessoaMapper.modelToDto(pessoaModel);
    }

    @Transactional
    public PessoaDto createPessoa(PessoaForm pessoaForm) {
        if (pessoaRepository.findByEmailContainingIgnoreCase(pessoaForm.getEmail()).isPresent()) {
            throw new PessoaAlreadyExists(
                    String.format("O email '%s' já está cadastrado", pessoaForm.getEmail())
            );
        }
        try {
            PessoaModel newPessoaModel = pessoaMapper.formToModel(pessoaForm);
            pessoaRepository.save(newPessoaModel);
            return pessoaMapper.modelToDto(newPessoaModel);
        } catch (DataIntegrityViolationException err) {
            throw new PessoaInsertException(
                    String.format("falha ao cadastras a pessoa", pessoaForm.getName())
            );
        }
    }

    @Transactional
    public PessoaDto updatePessoa(PessoaForm pessoaForm, String email) {
        if (pessoaRepository.findByEmailContainingIgnoreCase(email).isEmpty()) {
            throw new PessoaNotFoundExeception(
                    String.format("Pessoa com o email '%s' não foi encontrado ", email)
            );
        }
        PessoaModel pessoaModel = getPessoaModelByEmail(email);
        try {
            PessoaModel updatePessoaModel = pessoaMapper.updateFormToModel(pessoaForm, pessoaModel);
            pessoaRepository.save(updatePessoaModel);
            return pessoaMapper.modelToDto(updatePessoaModel);
        } catch (ConstraintViolationException | DataIntegrityViolationException | OptimisticLockingFailureException e) {
            throw new PessoaUpdateException(
                    String.format("falha ao atualizar a pessoa ", pessoaForm.getName())
            );
        }

    }

   @Transactional
    public void deletePessoa(String email){
        PessoaModel pessoaModel = getPessoaModelByEmail(email);
        pessoaModel.setActive(false);
        pessoaRepository.save(pessoaModel);

    }

    public Set<PessoaDto> getAllPessoa (){
        Set<PessoaModel> pessoaModels = pessoaRepository.findByIsActiveTrue();
        if (pessoaModels.isEmpty()){
            throw new PessoaNotFoundExeception(
                    String.format("pessoas não encontradas ")
            );
        }
    return pessoaMapper.setModelToSetDto(pessoaModels);
    }

    @Transactional
    public Set<PessoaDto> createPessoaLote (List<PessoaForm> pessoaFormList){
        List<PessoaModel> pessoaModelsList = pessoaFormList.stream()
                .filter(form -> pessoaRepository.findByEmailContainingIgnoreCase(form.getEmail()).isEmpty())
                .map(pessoaMapper::formToModel)
                .peek(model -> model.setActive(true))
                .toList();
        List<PessoaModel> saved = pessoaRepository.saveAll(pessoaModelsList);

        return saved.stream()
                .map(pessoaMapper::modelToDto)
                .collect(Collectors.toSet());
    }

    @Transactional
    public Set<PessoaDto> updatePessoaLote(List<PessoaForm> pessoaFormList) {
        List<PessoaModel> pessoasAtualizadas = new ArrayList<>();

        for (PessoaForm form : pessoaFormList) {
            try {
                PessoaModel existente = getPessoaModelByEmail(form.getEmail());
                pessoaMapper.updateFormToModel(form, existente);

                pessoasAtualizadas.add(existente);
            } catch (PessoaNotFoundExeception e) {
                throw new PessoaNotFoundExeception(
                        String.format("Pessoa(s) '%s' não encontra(s)", form.getName())
                );
            }
        }

        List<PessoaModel> pessoasSalvas = pessoaRepository.saveAll(pessoasAtualizadas);

        return pessoasSalvas.stream()
                .map(pessoaMapper::modelToDto)
                .collect(Collectors.toSet());
    }
    public void deletePessoaLote (Set<String> emails){
        List<PessoaModel> emailsDelete = new ArrayList<>();
        for (String email : emails ){
            try {
                PessoaModel pessoaExistente = getPessoaModelByEmail(email);
                pessoaExistente.setActive(false);
                emailsDelete.add(pessoaExistente);
            }catch (PessoaNotFoundExeception e) {
                throw new PessoaNotFoundExeception(
                        String.format("Email(s) '%s' não encontra(s)", email)
                );
            }
        }
        List<PessoaModel> pessoasDeletadas = pessoaRepository.saveAll(emailsDelete);
    }

}
