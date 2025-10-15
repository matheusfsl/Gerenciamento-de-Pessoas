package com.pessoa.pessoa.controller;

import com.pessoa.pessoa.dto.request.PessoaForm;
import com.pessoa.pessoa.dto.response.PessoaDto;
import com.pessoa.pessoa.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/lote")
    public ResponseEntity<Set<PessoaDto>> createComida(@RequestBody List<PessoaForm> pessoaFormList){
        Set<PessoaDto> pessoaDtos = pessoaService.createPessoaLote(pessoaFormList);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDtos);
    }

    @PutMapping("/up")
    public ResponseEntity<Set<PessoaDto>> update(@RequestBody List<PessoaForm> pessoaFormList){
        Set<PessoaDto> pessoaDtos = pessoaService.updatePessoaLote(pessoaFormList);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDtos);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete (@RequestBody Set<String> emails){
        pessoaService.deletePessoaLote(emails);
        return ResponseEntity.noContent().build();
    }
}
