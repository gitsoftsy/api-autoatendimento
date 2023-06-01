package br.com.softsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.softsy.model.LoginRequest;
import br.com.softsy.model.RetornoAPI;
import br.com.softsy.rn.LoginRN;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = { "/aluno" }, method = RequestMethod.POST)
	public @ResponseBody RetornoAPI aluno(@RequestBody LoginRequest login) {
		LoginRN rn = new LoginRN();

		return rn.login(login, "Aluno");
	}
	
	
	@RequestMapping(value = { "/docente" }, method = RequestMethod.POST)
	public @ResponseBody RetornoAPI docente(@RequestBody LoginRequest login) {
		LoginRN rn = new LoginRN();

		return rn.login(login, "Docente");
	}
	
	@RequestMapping(value = { "/colaborador" }, method = RequestMethod.POST)
	public @ResponseBody RetornoAPI colaborador(@RequestBody LoginRequest login) {
		LoginRN rn = new LoginRN();

		return rn.login(login, "Colaborador");
	}
}
