package com.apialuno.apialuno.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@PrimaryKeyJoinColumn(name = "idpessoa")
@Table(name = "aluno")
public class AlunoModel extends PessoaModel{
    @NotBlank(message = "Campus não pode estar vazio")
    private String campus;
	private String polo;
    @NotBlank(message = "Email não pode estar vazio")
	private String email_institucional;
	private String coordenacao;
    private String curso;
	private String situacao;
    @NotBlank(message = "Periodo não pode estar vazio")
	private String periodo_entrada;

    public AlunoModel() {}

    public AlunoModel(String coordenacao, String curso, String situacao, String periodo_entrada, String campus, String polo, String email_institucional) {
		super();
		this.campus = campus;
		this.polo = polo;
		this.email_institucional = email_institucional;
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
	}
	
	public AlunoModel(String nomeEstudante, String coordenacao, String curso, String situacao,String periodo_entrada, String campus, String polo, String email_institucional, int idade, String sexo) {
		super(nomeEstudante, idade, sexo);
        this.campus = campus;
        this.polo = polo;
        this.email_institucional = email_institucional;
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
	}
	public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getPolo() {
        return polo;
    }

    public void setPolo(String polo) {
        this.polo = polo;
    }

    public String getEmail_institucional() {
        return email_institucional;
    }

    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }

    public String getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPeriodo_entrada() {
        return periodo_entrada;
    }

    public void setPeriodo_entrada(String periodo_entrada) {
        this.periodo_entrada = periodo_entrada;
    }

}
