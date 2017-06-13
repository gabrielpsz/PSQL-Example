package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConectaBD;
import model.Cliente;

public class ClienteDaoImp implements ClienteDAO {

	private ConectaBD conexao;
	private PreparedStatement ps = null;
	
	public ClienteDaoImp() {
		// TODO Auto-generated constructor stub
		conexao = new ConectaBD();
	}

	@Override
	public void salvar(Cliente e) {
		String nome = e.getNome();
		String email = e.getEmail();
		String sql = "INSERT into cliente (nome,email,data_de_nascimento) values (?,?,?)";
		try {
			Connection con = conexao.conexao();
			ps = con.prepareStatement(sql);
			ps.setObject(1, nome);
			ps.setObject(2, email);
			java.sql.Date sqlDate = new java.sql.Date(e.getDataDeNascimento().getTime());
			ps.setDate(3, sqlDate);
			ps.executeUpdate();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_cliente FROM cliente WHERE email LIKE " + "\'" + email + "\'");
			rs.next();
			e.setIdCliente(Long.parseLong(rs.getString(1)));
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void update(Cliente e) {

		String sql = "UPDATE cliente SET  nome = ?, email = ? WHERE id_cliente = ?";
		try {
			Connection con = conexao.conexao();
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getNome());
			ps.setString(2, e.getEmail());
			ps.setLong(3, e.getIdCliente());
			ps.execute();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void excluir(long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		try {
			Connection con = conexao.conexao();
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ps.execute();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void excluir(String nome) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cliente WHERE nome LIKE '?%'";
		try {
			Connection con = conexao.conexao();
			ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.execute();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public Cliente buscarPorId(long idcliente) {
		Cliente c = new Cliente();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT id_cliente, nome, email, data_de_nascimento FROM cliente WHERE id_cliente = " + "\'" + idcliente + "\'");
			while (rs.next()) {
				c.setIdCliente(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setDataDeNascimento(rs.getDate(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		List<Cliente> clientes = new ArrayList<>();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT id_cliente, nome, email, data_de_nascimento FROM cliente WHERE upper(nome) LIKE upper(" + "\'" + nome + "%\')" +" ORDER BY id_cliente");
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setDataDeNascimento(rs.getDate(4));
				clientes.add(c);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_cliente, nome, email, data_de_nascimento FROM cliente ORDER BY id_cliente");
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setDataDeNascimento(rs.getDate(4));
				clientes.add(c);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

}
