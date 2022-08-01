package br.com.senai.projetouc8.servico;

import java.util.List;
import br.com.senai.projetouc8.orm.Produto;

public interface ProdutoServico {

	public List<Produto> listarProdutos();
	
}
