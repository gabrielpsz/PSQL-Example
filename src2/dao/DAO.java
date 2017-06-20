package dao;

public interface DAO<E> {

	void salvar(E e);
	void update(E e);
	void excluir(long id);
	
}
