package br.com.senai.projetouc8.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.projetouc8.orm.Produto;
import br.com.senai.projetouc8.repository.ProdutoRepository;

@Service
public class ProdutoServicoCRUD implements ProdutoServico {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> listarProdutos() {
		return (List<Produto>) repository.findAll();
	}

}
