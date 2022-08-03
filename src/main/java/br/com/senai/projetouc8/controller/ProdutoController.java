package br.com.senai.projetouc8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.projetouc8.orm.Produto;
import br.com.senai.projetouc8.servico.ProdutoServico;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoServico servico;

	@GetMapping({ "/produtos", "/" })
	public String listarProduto(Model modelo) {
		modelo.addAttribute("produto", servico.listarProdutos());
		return "produtos"; // mostrar a página produtos.html
	}

	@GetMapping({ "/produtos/{id}" })
	public String apagarProduto(@PathVariable Integer id) {
		servico.apagarProduto(id);
		return "redirect:/produtos"; // mostrar a página grupo.html
	}

	@GetMapping("/produtos/adicionar")
	public String adicionarProduto(Model modelo) {
		Produto produto = new Produto();
		modelo.addAttribute("produto", produto);
		return "formProduto";
	}

	@PostMapping("/produtos")
	public String salvarProduto(@ModelAttribute("Produtos") Produto produto) {
		servico.salvarProduto(produto);
		return "redirect:/produtos";
	}
	@GetMapping({"/produtos/editar/{id}"})
	public String editarProdutos(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("produto", servico.consultarProdutoId(id));
		return "editarProduto";
}

	@PostMapping("/produtos/{id}")
	public String atualizarProduto(@PathVariable Integer id, @ModelAttribute("produtos") Produto produto, Model modelo) {
		Produto prod = servico.consultarProdutoId(id);
		prod.setId(id);
		prod.setProduto(produto.getProduto());
		prod.setQuantidade(produto.getQuantidade());
		prod.setPrecoCompra(produto.getPrecoCompra());
		prod.setPrecoVenda(produto.getPrecoVenda());
		prod.setFornecedor(produto.getFornecedor());
		servico.atualizarProduto(prod);
		return "redirect:/produtos";
}
}