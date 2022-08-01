package br.com.senai.projetouc8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.senai.projetouc8.servico.ProdutoServico;
 

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoServico servico;
	
	@GetMapping({"/produtos", "/"})
	public String listarProduto(Model modelo) {
		modelo.addAttribute("produto", servico.listarProdutos());
		return "produtos"; //mostrar a página produtos.html
	}


}
