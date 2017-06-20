package conexao;
import java.sql.*;

public class ConectaBD {
	
	public static ConectaBD instance;

    private ConectaBD(){
        conexao();
    }
    
    public static ConectaBD getInstance() {
    	if (instance == null) {
    		instance = new ConectaBD();
    	}
    	return instance;
    }

    public Connection conexao(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdGabriel", "postgres", "root");
            System.out.println("Conectado!");
            return conexao;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("error: " + e);
            return null;
        }
    }

}