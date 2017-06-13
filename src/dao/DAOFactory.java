package dao;

public abstract class DAOFactory {
	
	/*private static UsuarioDAO usuarioDao;
	
	public static UsuarioDAO getUsuarioDao() {
		if (usuarioDao == null) {
			usuarioDao = new UsuarioDaoImp();
		}
		return usuarioDao;
	}
	
	private static SalaDAO salaDao;
	
	public static SalaDAO getSalaDao() {
		if (salaDao == null) {
			salaDao = new SalaDaoImp();
		}
		return salaDao;
	}
	
	private static ReservaDAO reservaDao;
	
	public static ReservaDAO getReservaDao() {
		if (reservaDao == null) {
			reservaDao = new ReservaDaoImp();
		}
		return reservaDao;
	}*/
	
	public static ClienteDAO clienteDao;
	
	public static ClienteDAO getClienteDao() {
		if (clienteDao == null) {
			clienteDao = new ClienteDaoImp();
		}
		return clienteDao;
	}
	
}
