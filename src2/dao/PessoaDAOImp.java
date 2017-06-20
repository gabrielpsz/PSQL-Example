package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.ConectaBD;
import modelo.Carro;
import modelo.Pessoa;

public class PessoaDAOImp implements PessoaDAO {

	private ConectaBD conexao = ConectaBD.getInstance();
	PreparedStatement preparedStatement = null;

	@Override
	public void salvar(Pessoa e) {
		String nome = e.getNome();
		String cpf = e.getCpf();
		java.sql.Date sqlDate = new java.sql.Date(e.getDataDeNascimento().getTime());
		String sql = "INSERT into pessoa (nome,cpf,data_de_nascimento) values (?,?,?)";
		try {
			Connection con = conexao.conexao();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setObject(1, nome);
			preparedStatement.setObject(2, cpf);
			preparedStatement.setDate(3, sqlDate);
			preparedStatement.executeUpdate();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_pessoa FROM pessoa WHERE cpf LIKE " + "\'" + cpf + "\'");
			rs.next();
			e.setId(Long.parseLong(rs.getString(1)));
			adicionaCarrosPessoa(e);
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	private void adicionaCarrosPessoa(Pessoa p) {
		String sqlCarroPessoa = "INSERT INTO carro_pessoa (id_carro, id_pessoa) VALUES (?,?)";
		try {
			Connection con = conexao.conexao();
			preparedStatement = con.prepareStatement(sqlCarroPessoa);
			JOptionPane.showMessageDialog(null, p.getCarros());
			for (Carro c : p.getCarros()) {
				preparedStatement.setObject(1, c.getId());
				preparedStatement.setObject(2, p.getId());
				preparedStatement.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Pessoa e) {
		String sql = "UPDATE pessoa SET nome = ?, cpf = ?, data_de_nascimento = ? WHERE id_pessoa = ?";
		try {
			Connection con = conexao.conexao();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, e.getNome());
			preparedStatement.setString(2, e.getCpf());
			java.sql.Date sqlDate = new java.sql.Date(e.getDataDeNascimento().getTime());
			preparedStatement.setDate(3, sqlDate);
			preparedStatement.setLong(4, e.getId());
			preparedStatement.execute();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void excluir(long id) {
		String sql = "DELETE FROM pessoa WHERE id_pessoa = ?";
		try {
			Connection con = conexao.conexao();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public Pessoa buscaPorID(long id) {
		Pessoa c = new Pessoa();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT id_pessoa, nome, cpf, data_de_nascimento FROM pessoa WHERE id_pessoa = "
							+ "\'" + id + "\'");
			while (rs.next()) {
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setCpf(rs.getString(3));
				c.setDataDeNascimento(rs.getDate(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Pessoa> buscarTodos() {
		List<Pessoa> pessoas = new ArrayList<>();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT id_pessoa, nome, cpf, data_de_nascimento FROM pessoa ORDER BY id_pessoa");
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getLong(1));
				p.setNome(rs.getString(2));
				p.setCpf(rs.getString(3));
				p.setDataDeNascimento(rs.getDate(4));
				pessoas.add(p);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pessoas;
	}

	@Override
	public List<Pessoa> buscarPorNome(String nome) {
		List<Pessoa> pessoas = new ArrayList<>();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id_pessoa, nome, cpf, data_de_nascimento FROM pessoa WHERE upper(nome) LIKE upper(" + "\'"
							+ nome + "%\')" + " ORDER BY id_pessoa");
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getLong(1));
				p.setNome(rs.getString(2));
				p.setCpf(rs.getString(3));
				p.setDataDeNascimento(rs.getDate(4));
				pessoas.add(p);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoas;
	}

	@Override
	public List<String> listaPessoaCarros() {
		List<String> pcs = new ArrayList<>();
		String sql = "select pessoa.nome, carro.placa from pessoa inner join carro_pessoa on "
				+ "(pessoa.id_pessoa = carro_pessoa.id_pessoa) inner join carro on carro.id_carro = carro_pessoa.id_carro;";
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String nome = rs.getString(1);
				String carro = rs.getString(2);
				pcs.add(nome);
				pcs.add(carro);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return pcs;
	}

}
