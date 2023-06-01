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
	
}
