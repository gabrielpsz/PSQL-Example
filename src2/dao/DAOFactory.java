package dao;

public abstract class DAOFactory {

	private static CarroDAO carroDAO;
	public static CarroDAO getCarroDAO() {
		if (carroDAO == null) {
			carroDAO = new CarroDAOImp();
		}
		return carroDAO;
	}
	
	private static PessoaDAO pessoaDAO;
	public static PessoaDAO getPessoaDAO() {
		if (pessoaDAO == null) {
			pessoaDAO = new PessoaDAOImp();
		}
		return pessoaDAO;
	}
}
