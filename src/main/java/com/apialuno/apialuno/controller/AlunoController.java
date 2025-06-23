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
import org.springframework.web.bind.annotation.PutMapping;



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
    
    @GetMapping
    public ResponseEntity<List<AlunoModel>> buscarTodos(){
        List<AlunoModel> listaAluno = alunoService.buscarTodos();
        return new ResponseEntity<>(listaAluno, HttpStatus.OK);
    }

    @GetMapping("/nome/{nomeEstudante}")
    public ResponseEntity<List<AlunoModel>> buscarPorNome(@PathVariable(value = "nomeEstudante") String nomeEstudante){
        List<AlunoModel> aluno = alunoService.buscarPorNome(nomeEstudante);
        if (aluno.isEmpty()) {
            return new ResponseEntity<>(aluno, HttpStatus.OK);
        }
        else {
        return new ResponseEntity<List<AlunoModel>>(aluno, HttpStatus.NOT_FOUND);
    }
    }

    @GetMapping("/curso/{curso}")
    public ResponseEntity<List<AlunoModel>> buscarPorCurso(@PathVariable(value = "curso") String curso){
        List<AlunoModel> aluno = alunoService.buscarPorCurso(curso);
        if (aluno.isEmpty()) {
            return new ResponseEntity<>(aluno, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<List<AlunoModel>>(aluno, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/idade/{idade}")
    public ResponseEntity<List<AlunoModel>> buscarPorIdade(@PathVariable(value = "idade") int idade){
        List<AlunoModel> aluno = alunoService.buscarPorIdade(idade);
        if (aluno.isEmpty()) {
            return new ResponseEntity<>(aluno, HttpStatus.OK);
        }
        else{
        return new ResponseEntity<List<AlunoModel>>(aluno, HttpStatus.NOT_FOUND);
        }
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
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        alunoService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<AlunoModel> editarAluno(@PathVariable long id, @Valid @RequestBody AlunoModel aluno) {
        Optional<AlunoModel> alunoEditavel = alunoService.buscarPorId(id);
        if (alunoEditavel.isPresent()) {
            AlunoModel alunoSalvo = aluno;
            aluno.setIdPessoa(id);
            alunoService.salvar(aluno);
            return new ResponseEntity<AlunoModel>(alunoSalvo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}