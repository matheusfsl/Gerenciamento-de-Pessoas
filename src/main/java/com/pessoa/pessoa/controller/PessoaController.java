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

    @GetMapping("/{emailPessoa}")
    public ResponseEntity<PessoaDto> getPessoa(@PathVariable String emailPessoa){
        PessoaDto pessoadto = pessoaService.getPessoaByEmail(emailPessoa);
        return ResponseEntity.ok(pessoadto);
    }

    @GetMapping("/{all}")
    public ResponseEntity<Set<PessoaDto>> getAllPessoa (){
        Set<PessoaDto> pessoaDtos = pessoaService.getAllPessoa();
        return ResponseEntity.ok(pessoaDtos);
    }

    @PostMapping("/create")
    public ResponseEntity<PessoaDto> createPessoa(@RequestBody PessoaForm pessoaForm){
        PessoaDto pessoaDto = pessoaService.createPessoa(pessoaForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);
    }

    @PutMapping("/{pessoaEmail}")
    public ResponseEntity<PessoaDto> updatePessoa (@PathVariable String pessoaEmail, @RequestBody PessoaForm pessoaForm){
        PessoaDto pessoaDto = pessoaService.updatePessoa(pessoaForm, pessoaEmail);
        return ResponseEntity.ok(pessoaDto);
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
