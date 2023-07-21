package br.com.softsy.model;

public class ListaCartoesAlunoRequest {

	private String aluno;
	private String cartao;
	private String tipo;
	private Long cobranca;
	private String obs;

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the aluno
	 */
	public String getAluno() {
		return aluno;
	}

	/**
	 * @return the cartao
	 */
	public String getCartao() {
		return cartao;
	}

	/**
	 * @param cartao the cartao to set
	 */
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	/**
	 * @return the cobranca
	 */
	public Long getCobranca() {
		return cobranca;
	}

	/**
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param cobranca the cobranca to set
	 */
	public void setCobranca(Long cobranca) {
		this.cobranca = cobranca;
	}

	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

}
