package br.com.softsy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.softsy.model.RetornoAPI;

@Controller
public class HcController {
	@RequestMapping(value = { "hc", "HC", "Hc", "hC" }, method = RequestMethod.GET)
	public @ResponseBody RetornoAPI area(HttpSession session, Model model) throws Exception {
		RetornoAPI retorno = new RetornoAPI();
		retorno.setSuccess(true);
		retorno.setMessage("Hello World");
		
		return retorno;
	}

}
