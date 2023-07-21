package br.com.softsy.model;

import java.sql.Date;

public class DisciplinaMatriculaAlunoResponse {

	private String aluno;
	private String disciplina;
	private String nomeDisciplina;
	private String turma;
	private Date dataMatricula;

	/**
	 * @return the aluno
	 */
	public String getAluno() {
		return aluno;
	}

	/**
	 * @return the disciplina
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * @return the turma
	 */
	public String getTurma() {
		return turma;
	}

	/**
	 * @return the dataMatricula
	 */
	public Date getDataMatricula() {
		return dataMatricula;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	/**
	 * @param disciplina the disciplina to set
	 */
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	/**
	 * @param turma the turma to set
	 */
	public void setTurma(String turma) {
		this.turma = turma;
	}

	/**
	 * @param date the dataMatricula to set
	 */
	public void setDataMatricula(Date date) {
		this.dataMatricula = date;
	}

	/**
	 * @return the nomeDisciplina
	 */
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	/**
	 * @param nomeDisciplina the nomeDisciplina to set
	 */
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

}
