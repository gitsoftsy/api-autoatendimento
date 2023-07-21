package br.com.softsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.softsy.model.AlunoObtemCobrancasRequest;
import br.com.softsy.model.ListaCartoesAlunoRequest;
import br.com.softsy.model.RetornoAPI;
import br.com.softsy.rn.AlunoRN;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	
	/**
	 * 
	 * S001
	 * 
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value = { "/financeiro/obtemCobrancas" }, method = RequestMethod.GET)
	public @ResponseBody RetornoAPI obtemCobrancas(@RequestBody AlunoObtemCobrancasRequest aluno) {
		AlunoRN rn = new AlunoRN();

		return rn.obtemCobrancas(aluno);
	}
	
	/**
	 * 
	 * S005
	 * 
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value = { "/financeiro/listaCartoesAluno" }, method = RequestMethod.GET)
	public @ResponseBody RetornoAPI listaCartoesAluno(@RequestBody ListaCartoesAlunoRequest aluno) {
		AlunoRN rn = new AlunoRN();

		return rn.listaCartoesAluno(aluno);
	}	
	
	/**
	 * 
	 * S006
	 * 
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value = { "/financeiro/deletaCartao" }, method = RequestMethod.POST)
	public @ResponseBody RetornoAPI deletaCartao(@RequestBody ListaCartoesAlunoRequest aluno) {
		AlunoRN rn = new AlunoRN();

		return rn.deletaCartao(aluno);
	}	
	
	/**
	 * 
	 * S008
	 * 
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value = { "/financeiro/definirCartaoPrincial" }, method = RequestMethod.POST)
	public @ResponseBody RetornoAPI definirCartaoPrincial(@RequestBody ListaCartoesAlunoRequest aluno) {
		AlunoRN rn = new AlunoRN();

		return rn.definirCartaoPrincial(aluno);
	}	
	
	/**
	 * 
	 * S014
	 * 
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value = { "/financeiro/geraProtocoloAtendiemento" }, method = RequestMethod.GET)
	public @ResponseBody RetornoAPI geraProtocoloAtendiemento(@RequestBody ListaCartoesAlunoRequest aluno) {
		AlunoRN rn = new AlunoRN();

		return rn.geraProtocoloAtendiemento(aluno);
	}

	/**
	 * 
	 * S018
	 * 
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value = { "/financeiro/definirMeioPagto" }, method = RequestMethod.POST)
	public @ResponseBody RetornoAPI definirMeioPagto(@RequestBody ListaCartoesAlunoRequest aluno) {
		AlunoRN rn = new AlunoRN();

		return rn.definirMeioPagto(aluno);
	}
	
	/**
	 * 
	 * S022
	 * 
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value = { "/financeiro/abrSolValoresIndevidos" }, method = RequestMethod.POST)
	public @ResponseBody RetornoAPI abrSolValoresIndevidos(@RequestBody ListaCartoesAlunoRequest aluno) {
		AlunoRN rn = new AlunoRN();

		return rn.abrSolValoresIndevidos(aluno);
	}

	/**
	 * 
	 * S028
	 * 
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value = { "/financeiro/listaMatrAluno" }, method = RequestMethod.GET)
	public @ResponseBody RetornoAPI listaMatrAluno(@RequestBody ListaCartoesAlunoRequest aluno) {
		AlunoRN rn = new AlunoRN();

		return rn.listaMatrAluno(aluno);
	}	
}
