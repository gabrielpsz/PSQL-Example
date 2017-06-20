package controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.DAOFactory;
import dao.PessoaDAO;
import modelo.Carro;
import modelo.Pessoa;

public class ControlePessoa {
	
	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public static ControlePessoa instance;
	private PessoaDAO pessoaDAO = DAOFactory.getPessoaDAO();
	
	private ControlePessoa() {
		
	}
	
	public static ControlePessoa getInstance() {
		if (instance == null) {
			instance = new ControlePessoa();
		}
		return instance;
	}
	
	public void salvar() {
		String nome = "Gabriel Pereira de Souza";
		String cpf = "067.072.339-80";
		String dataDeNascimento = "01/07/1997";
		Carro carro = ControlePrincipal.getInstance().getCtrlCarro().getCarroDAO().buscaPorPlaca("AAA3333");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNasc = null;
		try {
			dataNasc = (Date) sdf.parseObject(dataDeNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Carro -> " +carro);
		Pessoa p = new Pessoa(nome, cpf, dataNasc, carro);
		pessoaDAO.salvar(p);
		
		nome = "Noas Giambelarjohnson de Zoça";
		cpf = "696.696.696-96";
		dataDeNascimento = "06/09/1969";
		carro = ControlePrincipal.getInstance().getCtrlCarro().getCarroDAO().buscaPorPlaca("AAA1111");
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataNasc = null;
		try {
			dataNasc = (Date) sdf.parseObject(dataDeNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Pessoa(nome, cpf, dataNasc, carro);
		pessoaDAO.salvar(p);
	}

}
