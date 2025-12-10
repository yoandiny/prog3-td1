import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    private DBConnection dbConnection;

    public DataRetriever(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        String req = "SELECT id, name FROM Category";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(req);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name")

                );

                categories.add(category);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    List<Product> getProductList (int page, int size) {
        List<Product> products = new ArrayList<>();

        String req = "SELECT * FROM Product ORDER BY id DESC LIMIT " + size + " OFFSET " + (page * size);

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(req);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),


                );

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    };
}
