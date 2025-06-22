package com.apialuno.apialuno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apialuno.apialuno.model.AlunoModel;
import com.apialuno.apialuno.service.AlunoService;

import jakarta.validation.Valid;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> buscarPorId(@PathVariable Long id){
        Optional<AlunoModel> aluno = alunoService.buscarPorId(id);
        if (aluno.isPresent()) {
            return new ResponseEntity<>(aluno.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new AlunoModel(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody AlunoModel aluno){
        String retorno = alunoService.salvar(aluno);
        try {
            return new ResponseEntity<>(retorno, HttpStatus.OK);    
        } catch (Exception e) {
            return new ResponseEntity<>(retorno, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<AlunoModel>> buscarTodos(){
        List<AlunoModel> listaAluno = alunoService.buscarTodos();
        return new ResponseEntity<>(listaAluno, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        alunoService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }

    @GetMapping("/nome/{nomeEstudante}")
    public ResponseEntity<AlunoModel> buscarPorNome(@PathVariable(value = "nomeEstudante") String nomeEstudante){
        Optional<AlunoModel> aluno = alunoService.buscarPorNome(nomeEstudante);
        if (aluno.isPresent()) {
            return new ResponseEntity<>(aluno.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new AlunoModel(), HttpStatus.NOT_FOUND);
    }

}