package br.com.softsy.model;

import java.math.BigDecimal;

public class AlunoObtemCobrancasResponse {

	private Long cobranca;
	private Long ano;
	private Long mes;
	private String aluno;
	private String resp;
	private String dataVencimento;
	private BigDecimal valorFaturado;
	private Boolean possuiCobrancasVencidas;
	private BigDecimal valorDesconto;
	private String dtVencDesconto;
	private BigDecimal valorPagar;
	private String msg;
	private String tipoCobranca;

	/**
	 * @return the cobranca
	 */
	public Long getCobranca() {
		return cobranca;
	}

	/**
	 * @param cobranca the cobranca to set
	 */
	public void setCobranca(Long cobranca) {
		this.cobranca = cobranca;
	}

	/**
	 * @return the ano
	 */
	public Long getAno() {
		return ano;
	}

	/**
	 * @param ano the ano to set
	 */
	public void setAno(Long ano) {
		this.ano = ano;
	}

	/**
	 * @return the mes
	 */
	public Long getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(Long mes) {
		this.mes = mes;
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
	 * @return the resp
	 */
	public String getResp() {
		return resp;
	}

	/**
	 * @param resp the resp to set
	 */
	public void setResp(String resp) {
		this.resp = resp;
	}

	/**
	 * @return the dataVencimento
	 */
	public String getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * @return the valorFaturado
	 */
	public BigDecimal getValorFaturado() {
		return valorFaturado;
	}

	/**
	 * @param valorFaturado the valorFaturado to set
	 */
	public void setValorFaturado(BigDecimal valorFaturado) {
		this.valorFaturado = valorFaturado;
	}

	/**
	 * @return the possuiCobrancasVencidas
	 */
	public Boolean getPossuiCobrancasVencidas() {
		return possuiCobrancasVencidas;
	}

	/**
	 * @param possuiCobrancasVencidas the possuiCobrancasVencidas to set
	 */
	public void setPossuiCobrancasVencidas(Boolean possuiCobrancasVencidas) {
		this.possuiCobrancasVencidas = possuiCobrancasVencidas;
	}

	/**
	 * @return the valorDesconto
	 */
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	/**
	 * @param valorDesconto the valorDesconto to set
	 */
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	/**
	 * @return the dtVencDesconto
	 */
	public String getDtVencDesconto() {
		return dtVencDesconto;
	}

	/**
	 * @param dtVencDesconto the dtVencDesconto to set
	 */
	public void setDtVencDesconto(String dtVencDesconto) {
		this.dtVencDesconto = dtVencDesconto;
	}

	/**
	 * @return the valorPagar
	 */
	public BigDecimal getValorPagar() {
		return valorPagar;
	}

	/**
	 * @param valorPagar the valorPagar to set
	 */
	public void setValorPagar(BigDecimal valorPagar) {
		this.valorPagar = valorPagar;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the tipoCobranca
	 */
	public String getTipoCobranca() {
		return tipoCobranca;
	}

	/**
	 * @param tipoCobranca the tipoCobranca to set
	 */
	public void setTipoCobranca(String tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

}
