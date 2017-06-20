package dao;

import java.util.List;
import modelo.Pessoa;

public interface PessoaDAO extends DAO<Pessoa>{
	
	Pessoa buscaPorID(long id);
	List<Pessoa> buscarTodos();
	List<Pessoa> buscarPorNome(String nome);
	List<String> listaPessoaCarros();
	
}
