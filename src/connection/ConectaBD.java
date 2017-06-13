package connection;
import java.sql.*;

public class ConectaBD {

    public ConectaBD(){
        conexao();
    }

    public Connection conexao(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            return conexao;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("error:" + e);
            return null;
        }
    }
}