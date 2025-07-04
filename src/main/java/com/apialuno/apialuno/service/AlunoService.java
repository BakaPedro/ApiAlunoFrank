package com.apialuno.apialuno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apialuno.apialuno.model.AlunoModel;
import com.apialuno.apialuno.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public String salvar(AlunoModel aluno){
        try {
            alunoRepository.saveAndFlush(aluno);
            return "Salvo com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public Optional<AlunoModel> buscarPorId(Long id){
        return alunoRepository.findById(id);
    }

    public List<AlunoModel> buscarPorNome(String nome){
        return alunoRepository.findByNomeEstudante(nome);
    }

    public List<AlunoModel> buscarPorCurso(String curso){
        return alunoRepository.findByCurso(curso);
    }

    public List<AlunoModel> buscarPorIdade(int idade){
        return alunoRepository.findByIdade(idade);
    }

    //testando simplificado
    public void deletarPorId(Long id){
        alunoRepository.deleteById(id);
    }
    
    public List<AlunoModel> buscarTodos(){
        return alunoRepository.findAll();
    }
}
