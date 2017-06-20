package controle;

import dao.CarroDAO;
import dao.DAOFactory;
import dao.PessoaDAO;

public class ControlePrincipal {
	
	private static ControlePrincipal instance;
	private ControleCarro ctrlCarro = ControleCarro.getInstance();
	private ControlePessoa ctrlPessoa = ControlePessoa.getInstance();
	
	private ControlePrincipal() {
		// TODO Auto-generated constructor stub
	}
	
	public static ControlePrincipal getInstance() {
		if (instance == null) {
			instance = new ControlePrincipal();
		}
		return instance;
	}

	public void salvaCarro() {
		// TODO Auto-generated method stub
		ctrlCarro.salvar();
	}
	
	public void salvaPessoa() {
		ctrlPessoa.salvar();
	}

	public ControleCarro getCtrlCarro() {
		return ctrlCarro;
	}

	public ControlePessoa getCtrlPessoa() {
		// TODO Auto-generated method stub
		return ctrlPessoa;
	}
	
	
	
	
}
