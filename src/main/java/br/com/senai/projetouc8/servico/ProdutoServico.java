package br.com.senai.projetouc8.servico;

import java.util.List;
import br.com.senai.projetouc8.orm.Produto;

public interface ProdutoServico {

	public List<Produto> listarProdutos();
	
	public void apagarProduto(Integer id);
	
	public Produto salvarProduto(Produto produto);
	
	public Produto consultarProdutoId(Integer id);
	
	public Produto atualizarProduto(Produto produto);

}
