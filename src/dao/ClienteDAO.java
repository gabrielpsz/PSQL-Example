package dao;

import java.sql.SQLException;
import java.util.List;

import model.Cliente;
public interface ClienteDAO extends DAO{

	Cliente buscarPorId(long idCliente);
	List<Cliente> buscarTodos();
	List<Cliente> buscarPorNome(String nome);
	
}
