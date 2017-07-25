import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import control.ControleCliente;

public class Principal {

	public static void main(String[] args) {
		/*ConnectionManager con = ConnectionManager.getInstance();
		Scanner sc = new Scanner(System.in);
		String sql = "INSERT into cliente (id,nome,email) values (default,?,?)";
		System.out.println("Digite seu nome");
		String nome = sc.nextLine();
		System.out.println("Digite seu email");
		String email = sc.nextLine();
		if (nome.length() > 0 && email.length() > 0) {
			try {
				PreparedStatement ps = null;
				ps = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
				ps.setObject(1, nome);
				ps.setObject(2, email);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}*/
		
		ControleCliente ctrl = ControleCliente.getInstance();
		ctrl.inicia();
        System.out.println("Salve");
	}

}
