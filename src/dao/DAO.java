package dao;

import model.Cliente;

public interface DAO {
	
	void salvar(Cliente c);
	void update(Cliente c);
	void excluir(long id);
	void excluir(String nome);

}
