package control;

import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.ClienteDAO;
import dao.DAOFactory;
import model.Cliente;
import view.TelaCliente;

public class ControleCliente {

	private static ControleCliente instance;
	private TelaCliente telaCliente;
	private ClienteDAO clienteDao = DAOFactory.getClienteDao();
	private ArrayList<Cliente> clientes;
	
	private ControleCliente() {
		this.clientes = new ArrayList<>();
		this.telaCliente = new TelaCliente(this);
	}
	
	public static ControleCliente getInstance() {
		if (instance == null) {
			instance = new ControleCliente();
		}
		return instance;
	}
	
	public void inicia() {
		telaCliente.inicia();
	}

	public void salvar(String nome, String email, String data) {
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNasc = null;
		try {
			dataNasc = (Date) format.parseObject(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cliente c = new Cliente(nome, email, dataNasc);
		clienteDao.salvar(c);
		clientes.add(c);
	}
	
	public void updateNome(long id, String nome) {
		for (Cliente c : clienteDao.buscarTodos()) {
			if (c.getIdCliente() == id) {
				c.setNome(nome);
				clienteDao.update(c);
				break;
			}
		}
	}
	
	public void updateEmail(long id, String email) {
		for (Cliente c : clienteDao.buscarTodos()) {
			if (c.getIdCliente() == id) {
				c.setEmail(email);
				clienteDao.update(c);
				break;
			}
		}
	}
	
	public void excluir(String nome) {
		clienteDao.excluir(nome);
	}
	
	public void excluir(long id) {
		clienteDao.excluir(id);
	}
	
	public String lista() {
		String lista = "";
		for (Cliente c : clienteDao.buscarTodos()) {
			lista += "ID: " +c.getIdCliente() +"\n";
			lista += "Nome: " +c.getNome() +"\n";
			lista += "Email: " +c.getEmail() +"\n";
			lista += "Data de nascimento: " +c.getDataDeNascimento() +"\n";
			lista += "-==================================-\n";
		}
		return lista;
	}
	
	public String pesquisaPorId(long id) {
		Cliente c = clienteDao.buscarPorId(id);
		return "ID: " +c.getIdCliente() +"\n" +"Nome: " +c.getNome() +"\n" +"Email: " +c.getEmail() +"\n" +"Data de nascimento: " +c.getDataDeNascimento();
	}
	
	public String pesquisaPorNome(String nome) {
		String lista = "";
		for (Cliente c : clienteDao.buscarPorNome(nome)) {
			lista += "ID: " +c.getIdCliente() +"\n";
			lista += "Nome: " +c.getNome() +"\n";
			lista += "Email: " +c.getEmail() +"\n";
			lista += "Data de nascimento: " +c.getDataDeNascimento() +"\n";
			lista += "-==================================-\n";
		}
		return lista;
	}

}
