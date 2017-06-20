package dao;

import java.util.List;

import modelo.Carro;

public interface CarroDAO extends DAO<Carro> {
	
	Carro buscaPorPlaca(String placa);
	List<Carro> buscarTodos();
	List<Carro> buscaPorMarca(String marca);
	void excluir(String nome);

}
