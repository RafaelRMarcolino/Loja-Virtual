package com.rafael.loja.virtual.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rafael.loja.virtual.models.Funcionario;
import com.rafael.loja.virtual.repository.FuncionarioRepositories;

@Controller
public class PrincipalController {
	
	@Autowired
	private FuncionarioRepositories funcionarioRepository;
	
	@GetMapping("/administrativo/funcionarios/cadastrar")
	public ModelAndView cadastrar(Funcionario funcionario) {
		
		ModelAndView mv = new ModelAndView("administrativo/funcionarios/cadastro");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	
	@GetMapping("/administrativo/funcionarios/listar")
	public String listar() {
		
	
		return "administrativo/funcionarios/cadastro";
	}
	
	
	@PostMapping("/administrativo/funcionarios/salvar")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result) {
		
	
		if(result.hasErrors()) {
			
			return cadastrar(funcionario);
		}
		
		funcionarioRepository.saveAndFlush(funcionario);
		return cadastrar(new Funcionario());
	}

}
