package br.com.softsy.rn;

import java.util.ArrayList;
import java.util.List;

import br.com.softsy.dao.LoginDAO;
import br.com.softsy.model.LoginRequest;
import br.com.softsy.model.LoginResponse;
import br.com.softsy.model.MensagemErro;
import br.com.softsy.model.RetornoAPI;
import br.com.softsy.utils.Validacoes;

public class LoginRN {

	public RetornoAPI login(LoginRequest login, String perfil) {
		RetornoAPI retorno = new RetornoAPI();
		List<MensagemErro> erros = new ArrayList<MensagemErro>();

		if (Validacoes.isNullOrEmpty(login.getUsuario())) {
			erros.add(new MensagemErro("Campo não preenchido.", "Usuário"));
		}

		if (Validacoes.isNullOrEmpty(login.getSenha())) {
			erros.add(new MensagemErro("Campo não preenchido.", "Usuário"));
		}

		if(erros.size() > 0) {
			retorno.setSuccess(false);
			retorno.setMessage("Erro na autenticação.");
			retorno.setResponse(erros);
		}
		else {
			//TODO: Deve verificar a autenticação no AD
			LoginDAO dao = new LoginDAO();
			
			if(perfil.equalsIgnoreCase("Aluno")) {
				LoginResponse response = dao.autenticacaoAluno(login.getUsuario());
				if(response == null || response.getAluno() == null) {
					erros.add(new MensagemErro("Usuário não encontrado.", login.getUsuario()));
					retorno.setSuccess(false);
					retorno.setMessage("Erro na autenticação.");
					retorno.setResponse(erros);
				}
				else {
					retorno.setSuccess(true);
					retorno.setMessage("Consulta realizada com sucesso.");
					retorno.setResponse(response);
				}
			}
		}

		return retorno;
	}
}
