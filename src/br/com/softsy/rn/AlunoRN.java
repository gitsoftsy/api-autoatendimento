package br.com.softsy.rn;

import java.util.ArrayList;
import java.util.List;

import br.com.softsy.dao.AlunoDAO;
import br.com.softsy.model.AlunoObtemCobrancasRequest;
import br.com.softsy.model.AlunoObtemCobrancasResponse;
import br.com.softsy.model.DisciplinaMatriculaAlunoResponse;
import br.com.softsy.model.GeraProtocoloFinanceiroResponse;
import br.com.softsy.model.ListaCartoesAlunoRequest;
import br.com.softsy.model.ListaCartoesAlunoResponse;
import br.com.softsy.model.MensagemErro;
import br.com.softsy.model.RetornoAPI;
import br.com.softsy.utils.Validacoes;

public class AlunoRN {

	/**
	 * 
	 * S001
	 * 
	 * @param aluno
	 * @return
	 */
	public RetornoAPI obtemCobrancas(AlunoObtemCobrancasRequest aluno) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(aluno.getCpf())) {
			erros.add(new MensagemErro("Campo não preenchido.", "CPF"));
		}

		if (Validacoes.isNullOrEmpty(aluno.getAluno())) {
			erros.add(new MensagemErro("Campo não preenchido.", "ALUNO"));
		}

		if (erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		} else {

			AlunoDAO dao = new AlunoDAO();

			AlunoObtemCobrancasResponse response = dao.obtemCobrancas(aluno);

			if (response == null || response.getAluno() == null) {
				retorno.setSuccess(false);
				retorno.setMessage("Erro na consulta.");
				retorno.setResponse(erros);
			} else {
				retorno.setSuccess(true);
				retorno.setMessage("Consulta realizada com sucesso.");
				retorno.setResponse(response);
			}
		}

		return retorno;
	}
	
	/**
	 * 
	 * S005
	 * 
	 * @param aluno
	 * @return
	 */
	public RetornoAPI listaCartoesAluno(ListaCartoesAlunoRequest aluno) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(aluno.getAluno())) {
			erros.add(new MensagemErro("Campo não preenchido.", "ALUNO"));
		}
		
		if (erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		} else {

			AlunoDAO dao = new AlunoDAO();

			List<ListaCartoesAlunoResponse> response = dao.listaCartoesAluno(aluno);

			if (response == null || response.isEmpty()) {
				retorno.setSuccess(false);
				retorno.setMessage("Erro na consulta.");
				retorno.setResponse(erros);
			} else {
				retorno.setSuccess(true);
				retorno.setMessage("Consulta realizada com sucesso.");
				retorno.setResponse(response);
			}
		}

		return retorno;
	}
	
	/**
	 * 
	 * S006
	 * 
	 * @param aluno
	 * @return
	 */
	public RetornoAPI deletaCartao(ListaCartoesAlunoRequest aluno) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(aluno.getAluno())) {
			erros.add(new MensagemErro("Campo não preenchido.", "ALUNO"));
		}
		
		if (Validacoes.isNullOrEmpty(aluno.getCartao())) {
			erros.add(new MensagemErro("Campo não preenchido.", "CARTAO"));
		}

		if (erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		} else {

			AlunoDAO dao = new AlunoDAO();

			String response = dao.deletaCartao(aluno);

			if (response == null || response.isEmpty()) {
				retorno.setSuccess(false);
				retorno.setMessage("Erro na consulta.");
				retorno.setResponse(erros);
			} else {
				retorno.setSuccess(true);
				retorno.setMessage("Consulta realizada com sucesso.");
				retorno.setResponse(response);
			}
		}

		return retorno;
	}

	/**
	 * 
	 * S008
	 * 
	 * @param aluno
	 * @return
	 */
	public RetornoAPI definirCartaoPrincial(ListaCartoesAlunoRequest aluno) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(aluno.getAluno())) {
			erros.add(new MensagemErro("Campo não preenchido.", "ALUNO"));
		}
		
		if (Validacoes.isNullOrEmpty(aluno.getCartao())) {
			erros.add(new MensagemErro("Campo não preenchido.", "CARTAO"));
		}

		if (erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		} else {

			AlunoDAO dao = new AlunoDAO();

			String response = dao.definirCartaoPrincial(aluno);

			if (response == null || response.isEmpty()) {
				retorno.setSuccess(false);
				retorno.setMessage("Erro na consulta.");
				retorno.setResponse(erros);
			} else {
				retorno.setSuccess(true);
				retorno.setMessage("Consulta realizada com sucesso.");
				retorno.setResponse(response);
			}
		}

		return retorno;
	}

	/**
	 * 
	 * S014
	 * 
	 * @param aluno
	 * @return
	 */
	public RetornoAPI geraProtocoloAtendiemento(ListaCartoesAlunoRequest aluno) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(aluno.getAluno())) {
			erros.add(new MensagemErro("Campo não preenchido.", "ALUNO"));
		}
		
		if (erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		} else {

			AlunoDAO dao = new AlunoDAO();

			GeraProtocoloFinanceiroResponse response = dao.geraProtocoloAtendiemento(aluno);

			if (response == null || response.getIdProtocolo().toString().isEmpty()) {
				retorno.setSuccess(false);
				retorno.setMessage("Erro na consulta.");
				retorno.setResponse(erros);
			} else {
				retorno.setSuccess(true);
				retorno.setMessage("Consulta realizada com sucesso.");
				retorno.setResponse(response);
			}
		}

		return retorno;
	}

	/**
	 * 
	 * S018
	 * 
	 * @param aluno
	 * @return
	 */
	public RetornoAPI definirMeioPagto(ListaCartoesAlunoRequest aluno) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(aluno.getAluno())) {
			erros.add(new MensagemErro("Campo não preenchido.", "ALUNO"));
		}
		
		if (Validacoes.isNullOrEmpty(aluno.getTipo())) {
			erros.add(new MensagemErro("Campo não preenchido.", "TIPO"));
		}

		if (erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		} else {

			AlunoDAO dao = new AlunoDAO();

			String response = dao.definirMeioPagto(aluno);

			if (response == null || response.isEmpty()) {
				retorno.setSuccess(false);
				retorno.setMessage("Erro na consulta.");
				retorno.setResponse(erros);
			} else {
				retorno.setSuccess(true);
				retorno.setMessage("Consulta realizada com sucesso.");
				retorno.setResponse(response);
			}
		}

		return retorno;
	}
	
	/**
	 * 
	 * S022
	 * 
	 * @param aluno
	 * @return
	 */
	public RetornoAPI abrSolValoresIndevidos(ListaCartoesAlunoRequest aluno) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(aluno.getAluno())) {
			erros.add(new MensagemErro("Campo não preenchido.", "ALUNO"));
		}
		
		if (Validacoes.isLongNull(aluno.getCobranca()) || Validacoes.isLongEmpty(aluno.getCobranca()) ) {
			erros.add(new MensagemErro("Campo não preenchido.", "COBRANCA"));
		}

		if (erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		} else {

			AlunoDAO dao = new AlunoDAO();

			String response = dao.abrSolValoresIndevidos(aluno);

			if (response == null || response.isEmpty()) {
				retorno.setSuccess(false);
				retorno.setMessage("Erro na consulta.");
				retorno.setResponse(erros);
			} else {
				retorno.setSuccess(true);
				retorno.setMessage("Consulta realizada com sucesso.");
				retorno.setResponse(response);
			}
		}

		return retorno;
	}

	
	/**
	 * 
	 * S028
	 * 
	 * @param aluno
	 * @return
	 */
	public RetornoAPI listaMatrAluno(ListaCartoesAlunoRequest aluno) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(aluno.getAluno())) {
			erros.add(new MensagemErro("Campo não preenchido.", "ALUNO"));
		}
		
		if (erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		} else {

			AlunoDAO dao = new AlunoDAO();

			List<DisciplinaMatriculaAlunoResponse> response = dao.listaMatrAluno(aluno);

			if (response == null || response.isEmpty()) {
				retorno.setSuccess(false);
				retorno.setMessage("Erro na consulta.");
				retorno.setResponse(erros);
			} else {
				retorno.setSuccess(true);
				retorno.setMessage("Consulta realizada com sucesso.");
				retorno.setResponse(response);
			}
		}

		return retorno;
	}
}
