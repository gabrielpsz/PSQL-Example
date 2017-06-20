package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConectaBD;
import modelo.Carro;

public class CarroDAOImp implements CarroDAO {
	
	private ConectaBD conexao = ConectaBD.getInstance();
	private PreparedStatement preparedStatement = null;

	@Override
	public void salvar(Carro e) {
		String placa = e.getPlaca();
		String modelo = e.getModelo();
		String marca = e.getMarca();
		String sql = "INSERT into carro (placa,modelo,marca) values (?,?,?)";
		try {
			Connection con = conexao.conexao();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setObject(1, placa);
			preparedStatement.setObject(2, modelo);
			preparedStatement.setObject(3, marca);
			preparedStatement.executeUpdate();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_carro FROM carro WHERE placa LIKE " + "\'" + placa + "\'");
			rs.next();
			e.setId(Long.parseLong(rs.getString(1)));
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void update(Carro e) {
		String sql = "UPDATE carro SET placa = ?, modelo = ?, marca = ? WHERE id_carro = ?";
		try {
			Connection con = conexao.conexao();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, e.getPlaca());
			preparedStatement.setString(2, e.getModelo());
			preparedStatement.setString(3, e.getMarca());
			preparedStatement.setLong(4, e.getId());
			preparedStatement.execute();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void excluir(String placa) {
		String sql = "DELETE FROM carro WHERE placa LIKE '?'";
		try {
			Connection con = conexao.conexao();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, placa);
			preparedStatement.execute();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void excluir(long id) {
		String sql = "DELETE FROM carro WHERE id_carro = ?";
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
	public Carro buscaPorPlaca(String placa) {
		Carro c = new Carro();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT id_carro, placa, modelo, marca FROM carro WHERE placa = " + "\'" + placa + "\'");
			while (rs.next()) {
				c.setId(rs.getLong(1));
				c.setPlaca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setMarca(rs.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Carro> buscarTodos() {
		List<Carro> carros = new ArrayList<>();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_carro, placa, modelo, marca FROM carro ORDER BY id_carro");
			while (rs.next()) {
				Carro c = new Carro();
				c.setId(rs.getLong(1));
				c.setPlaca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setMarca(rs.getString(4));
				carros.add(c);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carros;
	}

	@Override
	public List<Carro> buscaPorMarca(String marca) {
		List<Carro> carros = new ArrayList<>();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT id_carro, placa, modelo, marca FROM carro WHERE marca = " + "\'" + marca + "\'");
			while (rs.next()) {
				Carro c = new Carro();
				c.setId(rs.getLong(1));
				c.setPlaca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setMarca(rs.getString(4));
				carros.add(c);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carros;
	}

}
