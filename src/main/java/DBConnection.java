import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String URL = "jdbc:postgresql://localhost:5432/product_management_db";
    private  String USER = "product_manager_user";
    private  String PASSWORD = "123456";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            return null;
        }
    }

    public void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connexion réussie !");
        }
    }
}
