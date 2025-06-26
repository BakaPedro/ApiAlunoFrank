package com.apialuno.apialuno.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apialuno.apialuno.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{
    List<AlunoModel> findByNomeEstudante(String nomeEstudante); //busca especifica
    List<AlunoModel> findByIdade(int idade); 
    List<AlunoModel> findByCurso(String curso); 
}
