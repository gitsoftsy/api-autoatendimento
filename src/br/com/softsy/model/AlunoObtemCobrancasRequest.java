package br.com.softsy.model;

public class AlunoObtemCobrancasRequest {
	private String cpf;
	private String aluno;
	private Boolean vencidas;
	private Boolean aVencer;

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the aluno
	 */
	public String getAluno() {
		return aluno;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	/**
	 * @return the vencidas
	 */
	public Boolean getVencidas() {
		return vencidas;
	}

	/**
	 * @param vencidas the vencidas to set
	 */
	public void setVencidas(Boolean vencidas) {
		this.vencidas = vencidas;
	}

	/**
	 * @return the aVencer
	 */
	public Boolean getaVencer() {
		return aVencer;
	}

	/**
	 * @param aVencer the aVencer to set
	 */
	public void setaVencer(Boolean aVencer) {
		this.aVencer = aVencer;
	}

}
