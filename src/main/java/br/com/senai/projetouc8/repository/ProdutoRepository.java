package br.com.senai.projetouc8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.projetouc8.orm.Produto;


@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	

}
